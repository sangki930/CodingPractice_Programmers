package ¹è´Þ;

import java.util.*;

class Solution {
    public int solution(int n, int[][] road, int k) {
        int answer = 0;
        Map<Integer,Map<Integer,Integer>> graph = new HashMap<>();
        for(int[] r : road){
            int a = r[0], b = r[1], v = r[2];
            Map<Integer,Integer> arr1 = graph.getOrDefault(a,new HashMap<>())
                , arr2 = graph.getOrDefault(b,new HashMap<>());
            arr1.put(b,Math.min(arr1.getOrDefault(b,Integer.MAX_VALUE),v));
            arr2.put(a,Math.min(arr2.getOrDefault(a,Integer.MAX_VALUE),v));
            graph.put(a,arr1);
            graph.put(b,arr2);
        }
        // System.out.println(graph);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int dis[]=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[1]=0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            Map<Integer,Integer> tmp = graph.getOrDefault(node,new HashMap<>());
            for(int e : tmp.keySet()){
                if(dis[e]>dis[node]+tmp.get(e)){
                    dis[e] = Math.min(dis[node]+tmp.get(e),dis[e]);
                    queue.offer(e);
                }
                
            }
        }
        
        for(int i=1;i<dis.length;i++)
            if(dis[i]<=k) answer++;
        // System.out.println(Arrays.toString(dis));
        return answer;
    }
}