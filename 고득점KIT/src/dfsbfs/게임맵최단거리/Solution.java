package dfsbfs.게임맵최단거리;

import java.util.*;

class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString(){
        return " [ x : "+x+" , y : "+y;
    }

}

class Solution {

    static int dx[]= {-1,0,1,0};
    static int dy[]= {0,-1,0,1};

    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps[0].length;
        int m = maps.length;
        boolean visited[][]=new boolean[m][n];
        int board[][]=new int[m][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                if(maps[j][i]==1){
                    board[j][i]=100000;
                }else{
                    board[j][i]=0;
                }

        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0));
        board[0][0]=1;
        while(!queue.isEmpty()){

            Point p = queue.poll();
            int px = p.x;
            int py = p.y;
            if(visited[py][px])
                continue;
            visited[py][px]=true;
            for(int i=0;i<4;i++){

                int nx = px+dx[i];
                int ny = py+dy[i];

                if(nx>=0 && ny>=0 && nx<maps[0].length && ny<maps.length
                        && maps[ny][nx]==1){

                    board[ny][nx]=Math.min(board[py][px]+1,board[ny][nx]);
                    queue.offer(new Point(nx,ny));
                }

            }

        }

        return board[m-1][n-1]!=100000?board[m-1][n-1]:-1;
    }
}
