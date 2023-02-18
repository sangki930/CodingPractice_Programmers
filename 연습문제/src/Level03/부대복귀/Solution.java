package Level03.부대복귀;

import java.util.*;

class Data{
    int node;
    int dis;
    public Data(int node, int dis){
        this.node=node;
        this.dis=dis;
    }
}

class Solution {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] road : roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        for(int i=0;i<sources.length;i++){
            int source = sources[i];
            answer[i] = bfs(source,destination,n,graph);
        }

        return answer;
    }

    public int bfs(int s, int d, int n, ArrayList<Integer>[] graph){

        LinkedList<Data> queue = new LinkedList<>();
        int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
        boolean[] visited = new boolean[n+1];
        queue.offer(new Data(s,0));
        visited[s] = true;
        while(!queue.isEmpty()){

            Data data = queue.poll();
            if(data.node==d){
                return data.dis;
            }
            ArrayList<Integer> arr = graph[data.node];
            for(int p : arr){
                if(!visited[p]){
                    queue.offer(new Data(p,data.dis+1));
                    visited[p] = true;
                }
            }

        }

        return -1;
    }
}