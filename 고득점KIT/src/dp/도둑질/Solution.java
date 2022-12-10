package dp.도둑질;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        dp[0] = money[0];
        dp[1] = Math.max(money[0],money[1]);
        dp2[0] = money[n-1];
        dp2[1] = Math.max(money[n-1],money[n-2]);
        for(int i=2;i<n-1;i++){
            dp[i]=Math.max(dp[i-1],money[i]+dp[i-2]);
            dp2[i]=Math.max(dp2[i-1],money[n-1-i]+dp2[i-2]);
        }
        return Math.max(dp[n-2],dp2[n-2]);
    }
}