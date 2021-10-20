package Week09;

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        Map<Integer,ArrayList<Integer>> tree = new HashMap<>();
        
        for(int[] wire : wires){
            int v1=wire[0],v2=wire[1];
            ArrayList<Integer> list = tree.getOrDefault(v1,new ArrayList<>());
            list.add(v2);
            tree.put(v1,list);
            list = tree.getOrDefault(v2,new ArrayList<>());
            list.add(v1);
            tree.put(v2,list);
        }
        
        for(int[] wire : wires){
            int v1=wire[0],v2=wire[1];
            LinkedList<Integer> queue = new LinkedList<>();
            queue.offer(1);
            int cnt=0;
            boolean visited[]=new boolean[n+1];
            while(!queue.isEmpty()){
                int node = queue.poll();
                cnt++;
                visited[node]=true;
                for(int i : tree.getOrDefault(node,new ArrayList<>())){
                    if((v1==node && v2==i) || (v1==i && v2==node) || visited[i]) continue;
                    queue.offer(i);
                }
            }
            answer = Math.min(answer, Math.abs(n-2*cnt));
        }
        
        return answer;
    }
}
