package kakaoInternship2020._03_보석쇼핑;

import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0,0};
        
        Set<String> gem_set = Arrays.stream(gems)
                                .map(i->(String)i)
                                .collect(Collectors.toSet());
        Map<String,Integer> gem_map = new HashMap<>();
        int left=0,right=0;
        int min_len=Integer.MAX_VALUE;
        while(left<=right && right<=gems.length){
            
            if(gem_set.size()>gem_map.keySet().size()){
                if(right<=gems.length-1)
                gem_map.put(gems[right],gem_map.getOrDefault(gems[right],0)+1);
                right++;
            }
            
            else if(gem_set.size()==gem_map.keySet().size()){
                
                
                gem_map.put(gems[left],gem_map.getOrDefault(gems[left],0)-1);
                
                if(gem_map.getOrDefault(gems[left],0)<=0)
                    gem_map.remove(gems[left]);
                left++;
                if(min_len>right-left){
                    min_len = right-left;
                    answer[0]=left;
                    answer[1]=right;
                }
            }
            
        }
        
        return answer;
    }
}
