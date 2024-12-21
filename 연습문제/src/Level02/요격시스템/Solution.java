package Level02.요격시스템;

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets,(a,b)->{
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int max = targets[0][1];
        for(int i=1;i<targets.length;i++){
            if(max > targets[i][1])
                max = targets[i][1];
            if(max <= targets[i][0]){
                max = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}