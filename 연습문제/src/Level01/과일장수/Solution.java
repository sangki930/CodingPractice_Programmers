package Level01.과일장수;

import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        score = Arrays.stream(score)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        int cnt = 0;
        int p = Integer.MAX_VALUE;
        for(int i=0;i<score.length;i++){
            int v = score[i];
            if(v>k) continue;
            p = Math.min(v,p);
            cnt++;
            if(cnt==m){
                answer+=p*m;
                cnt = 0;
                p = Integer.MAX_VALUE;
            } 
        }
        
        return answer;
    }
}