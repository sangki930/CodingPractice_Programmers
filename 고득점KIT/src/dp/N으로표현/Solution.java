package dp.N으로표현;

import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes,(a,b)->a[0]-b[0]);
        int tmp = routes[0][1];
        for(int i=0;i<routes.length-1;i++){
            if(tmp>routes[i][1])
                tmp=routes[i][1];
            if(tmp<routes[i+1][0]){
                tmp=routes[i+1][1];
                answer++;
            }     
        }
        return answer;
    }
}