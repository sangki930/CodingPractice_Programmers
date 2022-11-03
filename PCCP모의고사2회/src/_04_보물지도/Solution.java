package _04_보물지도;

import java.util.*;

class Point{
    int x,y; // 열,행
    boolean isUsed;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Point(int x, int y,boolean isUsed){
        this.x=x;
        this.y=y;
        this.isUsed=isUsed;
    }
}

class Solution {
    
    int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public int solution(int n, int m, int[][] hole) {
        long answer = 0;
        
        int[][] map = new int[n][m];
        long[][][] dp = new long[2][n][m];
        for(int k=0;k<2;k++)
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    dp[k][i][j] = Integer.MAX_VALUE; // k = 0 신발미사용, k = 1 신발 사용
                }
            }
        
        for(int[] tmp : hole){
            map[tmp[0]-1][tmp[1]-1] = -1;
        }
        
        LinkedList<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0,false));
        
        for(int k=0;k<2;k++)
            dp[k][0][0] = 0;
        
        // BFS + DP
        while(!queue.isEmpty()){
            Point point = queue.poll();
            
            if(point.x==n-1 && point.y==m-1) continue;
            for(int i=0;i<4;i++){
                int nx = point.x+dx[i];
                int ny = point.y+dy[i];
                if(!point.isUsed)
                    if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny]!=-1
                      && dp[0][nx][ny]>dp[0][point.x][point.y]+1){
                        dp[0][nx][ny] = dp[0][point.x][point.y]+1;
                        queue.offer(new Point(nx,ny,false));
                    }
                if(point.isUsed){
                    if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny]!=-1
                      && dp[1][nx][ny]>dp[1][point.x][point.y]+1){
                        dp[1][nx][ny] = dp[1][point.x][point.y]+1;
                        queue.offer(new Point(nx,ny,true));
                    }
                }
                int nx1 = nx+dx[i];
                int ny1 = ny+dy[i];
                if(!point.isUsed &&
                    0<=nx1 && nx1<n && 0<=ny1 && ny1<m && map[nx1][ny1]!=-1
                  && dp[1][nx1][ny1]>dp[0][point.x][point.y]+1){
                 dp[1][nx1][ny1] = Math.min(dp[1][nx1][ny1],dp[0][point.x][point.y]+1);
                    queue.offer(new Point(nx1,ny1,true));
                }
            }
        }
        
        answer = Math.min(dp[0][n-1][m-1],dp[1][n-1][m-1]);
        return answer==Integer.MAX_VALUE?-1:(int)answer;
    }
}