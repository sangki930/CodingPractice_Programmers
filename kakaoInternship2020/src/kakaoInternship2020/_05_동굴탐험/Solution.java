package kakaoInternship2020._05_µ¿±¼Å½Çè;

import java.util.*;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        boolean v[] = new boolean[n];
        int before[]=new int[n];
        int save[]=before.clone();
        
        for(int[] p : path){
            
            int s=p[0];
            int e=p[1];
            
            ArrayList<Integer> s_arr = map.getOrDefault(s,new ArrayList<>());
            ArrayList<Integer> e_arr = map.getOrDefault(e,new ArrayList<>());
            s_arr.add(e);
            e_arr.add(s);
            
            map.put(s,s_arr);
            map.put(e,e_arr);
        }
        
        for(int o[]:order){
            before[o[1]]=o[0];
        }
        
        if(before[0]!=0)
            return false;
        
        v[0]=true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addAll(map.getOrDefault(0,new ArrayList()));
        
        while(!queue.isEmpty()){
            int e = queue.poll();
            
            if(v[e])
                continue;
            
            if(!v[before[e]]){
                save[before[e]]=e;
                continue;
            }
            
            v[e]=true;
            queue.addAll(map.getOrDefault(e,new ArrayList()));
            queue.add(save[e]);
        }
        for(int i=0;i<n;i++){
            if(!v[i])
                return false;
        }
        
        return answer=true;
    }
}
