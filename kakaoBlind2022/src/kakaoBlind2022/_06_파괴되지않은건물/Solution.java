package kakaoBlind2022._06_파괴되지않은건물;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length, m = board[0].length;
        int[][] acc = new int[n+1][m+1];
        
        for(int[] s : skill){
            int type = s[0], r1 = s[1], c1  =s[2], r2 = s[3], c2 = s[4];
            int degree = type==1?-s[5]:s[5];
            acc[r1][c1] +=degree;
            acc[r1][c2+1] -=degree;
            acc[r2+1][c1] -=degree;
            acc[r2+1][c2+1] +=degree;
        }
        
        for(int i=0;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                acc[i][j]+=acc[i][j-1];
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                acc[i][j]+=acc[i-1][j];
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int sum = acc[i][j]+board[i][j];
                if(sum>0) answer++;
            }
        }
        
        return answer;
    }
}