package 예상_대진표;

import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int answer = 0;
        int n = t.length();
        Set<String> set = Set.of(strs);
        int dp[]=new int[n+1];
        
        for(int i=1;i<n+1;i++){
            dp[i]=20001;
            int s=0;
            for(int j=1;j<6;j++){
                s=Math.max(i-j,0);
                if(i<j) continue;
                if(set.contains(t.substring(s,i)))
                    dp[i]=Math.min(dp[i],dp[i-j]+1);
            }
        }
        if(dp[dp.length-1]==20001)
            return -1;
        
        return dp[dp.length-1];
    }
}