package _03코딩테스트공부;

import java.util.*;

class Solution {
    final int v = 151;
    int[] dx = {1,0}, dy = {0,1};
    public int solution(int alp, int cop, int[][] problems) {
        int answer = Integer.MAX_VALUE;
        int alp_max = 0, cop_max = 0;
        int[][] dp = new int[v+1][v+1];
        
        for(int[] problem : problems){
            alp_max = Math.max(problem[0],alp_max);
            cop_max = Math.max(problem[1],cop_max);
        }
        
        alp = Math.min(alp_max,alp);
        cop = Math.min(cop_max,cop);
        
        for(int i=0;i<v;i++)
            Arrays.fill(dp[i],(int)Math.pow(2,30));
        dp[alp][cop] = 0;
        for(int i=alp;i<=alp_max;i++){
            for(int j=cop;j<=cop_max;j++){
                if(i+1<=alp_max){
                    dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
                }
                if(j+1<=cop_max){
                    dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);
                }
                for(int[] problem : problems){
                    int alp_req = problem[0];
                    int cop_req = problem[1];
                    int alp_rwd = problem[2];
                    int cop_rwd = problem[3];
                    int cost = problem[4];
                    if(i>=alp_req && j>=cop_req){
                        int alp_next = Math.min(alp_max,i+alp_rwd);
                        int cop_next = Math.min(cop_max,j+cop_rwd);
                        dp[alp_next][cop_next] = Math.min(dp[alp_next][cop_next],dp[i][j]+cost);
                    }
                }
            }
        }
        
        return answer = dp[alp_max][cop_max];
    }
}
