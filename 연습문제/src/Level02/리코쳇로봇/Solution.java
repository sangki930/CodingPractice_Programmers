package Level02.리코쳇로봇;

import java.util.*;

class Data{
    int x,y;
    int dis;
    public Data(int x, int y, int dis){
        this.x=x;
        this.y=y;
        this.dis=dis;
    }
}

class Solution {

    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public int solution(String[] board) {
        int answer = -1;
        int r = board.length, c = board[0].length();
        char[][] map = new char[r][c];
        int s_x = -1, s_y = -1;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                char ch = board[i].charAt(j);
                map[i][j] = ch;
                if(ch=='R'){
                    s_x = i;s_y = j;
                }
            }
        }

        LinkedList<Data> queue = new LinkedList<>();
        queue.offer(new Data(s_x,s_y,0));
        boolean[][] visited = new boolean[r][c];
        // visited[s_x][s_y] = true;
        loop:while(!queue.isEmpty()){
            Data data = queue.poll();
            if(visited[data.x][data.y]) continue;
            visited[data.x][data.y] = true;
            if(map[data.x][data.y]=='G'){
                answer = data.dis;
                break loop;
            }
            for(int i=0;i<4;i++){
                for(int j=0;j<=100;j++){
                    int nx = data.x+dx[i]*j;
                    int ny = data.y+dy[i]*j;
                    int dis = data.dis+1;
                    if(0<=nx && nx<r && 0<=ny && ny<c && map[nx][ny]!='D'){
                        continue;
                    }
                    queue.offer(new Data(nx-dx[i],ny-dy[i],dis));
                    // visited[nx-dx[i]][ny-dy[i]] = true;
                    break;
                }

            }
        }

        return answer;
    }
}