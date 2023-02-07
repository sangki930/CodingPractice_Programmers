package kakaoBlind2023._02_택배배달과수거하기;

import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int[] d_acc = new int[n+1], p_acc = new int[n+1];
        for(int i=n-1, j=1;i>=0;i--,j++){
            d_acc[i] = d_acc[i+1] + deliveries[i];
            p_acc[i] = p_acc[i+1] + pickups[i];
            while(d_acc[i]>0 || p_acc[i]>0){
                d_acc[i]-=cap;
                p_acc[i]-=cap;
                answer+=(i+1)*2;
            }
        }
        
        return answer;
    }
}