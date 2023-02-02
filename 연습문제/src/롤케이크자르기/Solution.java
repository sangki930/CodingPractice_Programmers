package 롤케이크자르기;

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer,Integer> brother = new HashMap<>(), chulsu = new HashMap<>();
        
        for(int i=0;i<topping.length;i++){
            int v = topping[i];
            brother.put(v,brother.getOrDefault(v,0)+1);
        }
        
        for(int i=0;i<topping.length;i++){
            int v = topping[i];
            brother.put(v,brother.getOrDefault(v,0)-1);
            if(brother.getOrDefault(v,0)==0) brother.remove(v);
            chulsu.put(v,chulsu.getOrDefault(v,0)+1);
            if(brother.size()==chulsu.size()) answer++;
        }
        
        return answer;
    }
}