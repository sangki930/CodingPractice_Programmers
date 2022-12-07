package _2xN타일링;

class Solution {
    
    static int dp[]=new int[60001];
    public int cal(int n){
        
        if(n==1){
            dp[n]=1;
            return 1;
        }
        else if(n==2){
            dp[n]=2;
            return 2;
        }
        if(dp[n]!=0)
            return dp[n];
        return dp[n]=(cal(n-1)+cal(n-2))%1000000007;
        
    }
    public int solution(int n) {
        return cal(n);
    }
}