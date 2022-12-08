package _04_미로_탈출;

import java.util.*;

class Data{
    String node;
    int dist;
    boolean[] onTrap; // Ʈ���� ��Ҵ� ��(��Ʈ)
    // int pre; // v : ���ο� ����Ǿ� �ִ� ���
    public Data(String node, int dist, boolean[] onTrap){
        this.dist=dist;
        this.node=node;
        this.onTrap=onTrap;
        // this.v=pre;
    }
}

class Solution {
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        int[][] mat = new int[n+1][n+1];
        boolean[] isTrap = new boolean[n+1];
        Map<String,ArrayList<String>> map = new HashMap<>();
        Map<Integer,Integer> trapMap = new HashMap<>();
        int idx=0;
        for(int trap : traps){
            isTrap[trap]=true;
            trapMap.put(trap,idx++);
        }
            
        for(int i=0;i<=n;i++)
            Arrays.fill(mat[i],Integer.MAX_VALUE);
        
        for(int[] road : roads){
            int s = road[0], e = road[1], v = road[2];
            mat[s][e] = Math.min(v,mat[s][e]);
            if(isTrap[s] || isTrap[e]){
                mat[e][s] = mat[s][e];
                ArrayList<String> arr1,arr2;
                if(isTrap[s] && !isTrap[e]){
                    arr1 = map.getOrDefault(s+"F",new ArrayList<>());
                    arr2 = map.getOrDefault(e+"F",new ArrayList<>());
                    arr1.add(e+"F");
                    arr2.add(s+"T");
                    map.put(s+"F",arr1);
                    map.put(e+"F",arr2);
                }else if(!isTrap[s] && isTrap[e]){
                    arr1 = map.getOrDefault(s+"F",new ArrayList<>());
                    arr2 = map.getOrDefault(e+"T",new ArrayList<>());
                    arr1.add(e+"F");
                    arr2.add(s+"F");
                    map.put(s+"F",arr1);
                    map.put(e+"T",arr2);
                }else if(isTrap[s] && isTrap[e]){
                    arr1 = map.getOrDefault(s+"F",new ArrayList<>());
                    arr2 = map.getOrDefault(e+"T",new ArrayList<>());
                    arr1.add(e+"F");
                    arr2.add(s+"T");
                    map.put(s+"F",arr1);
                    map.put(e+"T",arr2);
                }
            }
        }
        
        PriorityQueue<Data> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.dist==b.dist)
                    return Integer.compare(a.dist,b.dist);
                return a.node.compareTo(b.node);
            }
        );
        pq.offer(new Data(start+"F",0,new boolean[traps.length]));
        int[][] disArr = new int[2][n+1];
        boolean[][] visited = new boolean[2][n+1];
        for(int i=0;i<2;i++)
            Arrays.fill(disArr[i],Integer.MAX_VALUE);
        disArr[0][start] = 0;
        
        while(!pq.isEmpty()){
            Data data = pq.poll();
            String p = data.node;
            
            int st = Integer.parseInt(data.node.substring(0,data.node.length()-1));
            char ch = data.node.charAt(data.node.length()-1);
            int sw = ch=='F'?0:1;
            
            System.out.println(data.node);
            if(isTrap[st]){
                System.out.println(st);
                if(ch == 'T'){
                    p = st+"F";
                }else{
                    p = st+"T";
                }
                if(data.onTrap[trapMap.get(st)]){
                    
                    data.onTrap[trapMap.get(st)]=false;
                    sw = 0;
                }else{
                    
                    data.onTrap[trapMap.get(st)]=true;
                    sw = 1;
                }
            }
            System.out.println(p+"==>"+Arrays.toString(data.onTrap));
            if(visited[sw][st]) continue;
            visited[sw][st] = true;
            ArrayList<String> tmp = map.getOrDefault(p,new ArrayList<>());
            
            for(String node : tmp){
                String newNode = node;
                int ed
                    = Integer.parseInt(newNode.substring(0,newNode.length()-1));
                boolean[] onTrap = data.onTrap.clone();
                char c = newNode.charAt(newNode.length()-1);
                int sw2 = c=='F'?0:1;
                if(disArr[sw2][ed] > disArr[sw][st] + mat[st][ed]){
                    disArr[sw2][ed] = disArr[sw][st] + mat[st][ed];
                    pq.offer(new Data(newNode,data.dist+mat[st][ed],onTrap));
                }
            }
        }
        // System.out.println(1<<-1);
        return answer = disArr[0][end];
    }
}