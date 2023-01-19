package 시소짝꿍;

import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(int[] weights) {
        long answer = -preprocess(weights)*2;
        // weights = Arrays.stream(weights).distinct().toArray();	
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        int idx = 0;
        for(int weight : weights){
            for(int i=2;i<=4;i++){
                ArrayList<Integer> arr = map.getOrDefault(weight*i,new ArrayList<>());
                arr.add(idx);
                map.put(weight*i,arr);
            }
            idx++;
        }
        
        for(int key : map.keySet()){
            ArrayList<Integer> arr = map.get(key);
            int size = arr.size();
            if(size>=2){
                answer+=((long)size)*((long)size-1)/2L;
            }
        }
        
        return answer;
    }
    
    // 중복 거르기
    public long preprocess(int[] weights){
        int[] counter = new int[1001];
        for(int weight : weights) counter[weight]++;
        long ret = 0;
        for(int i : counter){
            if(i>=2) ret+=(long)i*((long)i-1L)/2L;
        }
        
        return ret;
    }
}