package 최적의행렬곱셈;

//ref : https://source-sc.tistory.com/24
class Solution {
 public int solution(int[][] matrix_sizes) {
     int a,b;
     int i,j,k;
     int n = matrix_sizes.length;
     int[][] dp = new int[n+1][n+1];
     for(i=0;i<n;i++){
         for(j=0;j<n-i;j++){
                 a = j;
                 b = j+i;
                 if(a == b){
                     dp[a][b] = 0;
                 }
                 else{
                     dp[a][b] = 987654321;
                     for(k = a; k < b; k++){
                         dp[a][b] = Math.min(dp[a][b],dp[a][k] + dp[k+1][b] + ( matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1] ));
                     }
                 }
             }
         }
     return dp[0][n-1];
 }
}
