package Level02.할인행사;

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String,Integer> indices = new HashMap<>();
        for(int i=0;i<want.length;i++){
            indices.put(want[i],i);
        }

        for(int i=0;i<=discount.length-10;i++){
            int[] tmp = new int[want.length];
            for(int j=i;j<i+10;j++){
                int k = indices.getOrDefault(discount[j],-1);
                if(k==-1){
                    continue;
                }
                tmp[k]++;
            }
            boolean flag = true;
            for(int j=0;j<want.length;j++){
                if(tmp[j]!=number[j]) flag = false;
            }
            if(flag) answer++;
        }

        return answer;
    }
}