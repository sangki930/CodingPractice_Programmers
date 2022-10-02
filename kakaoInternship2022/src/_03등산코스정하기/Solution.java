package _03등산코스정하기;

import java.util.*;

class Edge{
    int e;
    int w;
    public Edge(int e, int w){
        this.e=e;
        this.w=w;
    }
}

class Rec{
    int id;
    int intensity;
    int ex;
    public Rec(int id, int intensity){
        this.id=id;
        this.intensity=intensity;
    }
}

class Solution {
    ArrayList<ArrayList<Edge>> arr= new ArrayList<>();
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {Integer.MAX_VALUE,Integer.MAX_VALUE-1};

        boolean[] isGate = new boolean[n+1];
        boolean[] isSummit = new boolean[n+1];

        for(int i=0;i<=n;i++)
            arr.add(new ArrayList<>());
        for(int gate : gates)
            isGate[gate] = true;
        for(int summit: summits)
            isSummit[summit] = true;
        int[] tmp_arr = new int[n+1];
        Arrays.fill(tmp_arr,Integer.MAX_VALUE);
        for(int[] path : paths){
            int n1 = path[0], n2 = path[1], w = path[2];
            ArrayList<Edge> a1 = arr.get(n1);
            ArrayList<Edge> a2 = arr.get(n2);
            a1.add(new Edge(n2,w));
            a2.add(new Edge(n1,w));
            if(isGate[n1]){
                tmp_arr[n1] = Math.min(tmp_arr[n1],w);
            }
            if(isGate[n2]){
                tmp_arr[n2] = Math.min(tmp_arr[n1],w);
            }
        }
        Arrays.sort(summits);
        answer = new int[]{0,Integer.MAX_VALUE};
        int[] visited = new int[n+1];

        Arrays.fill(visited,1000000000);
        PriorityQueue<Rec> queue = new PriorityQueue<>(
            (a,b)->{
                return Integer.compare(a.intensity,b.intensity);
            }
        );
        for(int gate : gates){
            queue.offer(new Rec(gate,0));
            visited[gate] = 0;
        }

        int intensity = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Rec r = queue.poll();
            intensity = r.intensity;
            if(isSummit[r.id]) continue;
            if(intensity>visited[r.id]) continue;
            ArrayList<Edge> list = arr.get(r.id);
            for(Edge edge : list){
                int e = edge.e, w = edge.w;
                Rec tmp = new Rec(e,Math.max(r.intensity,w));
                tmp.ex = r.id;
                if(visited[e]>tmp.intensity){
                    visited[e] = tmp.intensity;
                    queue.offer(tmp);
                }
            }
        }
        for(int summit : summits)
            if(answer[1]>visited[summit]){
                answer[0] = summit;
                answer[1] = visited[summit];
            }
      
        return answer;
    }
}