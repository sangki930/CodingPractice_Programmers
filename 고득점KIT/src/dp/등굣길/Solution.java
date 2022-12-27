package dp.등굣길;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        long dp[][]=new long[n][m];
        
        for(int[] arr : puddles){
            dp[arr[1]-1][arr[0]-1]=-1;
        }
        
        for(int i=1;i<n;i++)
            if(dp[i][0]!=-1)
            dp[i][0]=1;
            else
            break;
        
        for(int i=1;i<m;i++)
            if(dp[0][i]!=-1)
            dp[0][i]=1;
            else
                break; 
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++)
                if(dp[i][j]!=-1){
                    if(dp[i][j-1]==-1){
                        dp[i][j]=dp[i-1][j]%1000000007;
                    }else if(dp[i-1][j]==-1){
                        dp[i][j]=dp[i][j-1]%1000000007;
                    }else
                    dp[i][j]=(dp[i][j-1]+dp[i-1][j])%1000000007;
                }
                    
       // System.out.println(Arrays.deepToString(dp));
        return (int)dp[n-1][m-1];
    }
}
