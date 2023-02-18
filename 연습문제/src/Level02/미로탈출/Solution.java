package Level02.미로탈출;

import java.util.*;

class Data{
    int x,y; // 행, 열
    int dis;
    public Data(int x, int y, int dis){
        this.x=x;
        this.y=y;
        this.dis=dis;
    }
}

class Solution {
    
    int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public int solution(String[] maps) {
        int r = maps.length;
        int c = maps[0].length();
        char[][] map = new char[r][c];
        int s_x = -1, s_y = -1;
        int e_x = -1, e_y = -1;
        int l_x = -1, l_y = -1;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                map[i][j] = maps[i].charAt(j);
                switch(map[i][j]){
                    case 'S'->{
                        s_x = i;s_y = j;
                    }
                    case 'E'->{
                        e_x = i;e_y = j;
                    }
                    case 'L'->{
                        l_x = i;l_y = j;
                    }
                    default->{
                        
                    }
                }
            }
        }
        
        int a = bfs(s_x,s_y,'L',map);
        if(a==-1) return -1;
        int b = bfs(l_x,l_y,'E',map);
        if(b==-1) return -1;
        
        return a+b;
    }
    
    public int bfs(int x, int y, char des, char[][] map){
        LinkedList<Data> queue = new LinkedList<>();
        int r = map.length;
        int c = map[0].length;
        boolean[][] visited = new boolean[r][c];
        queue.offer(new Data(x,y,0));
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Data data = queue.poll();
            if(map[data.x][data.y]==des){
                return data.dis;
            }
            for(int i=0;i<4;i++){
                int nx = data.x+dx[i];
                int ny = data.y+dy[i];
                if(0<=nx && nx<r && 0<=ny && ny<c && !visited[nx][ny] && map[nx][ny]!='X'){
                    queue.offer(new Data(nx,ny,data.dis+1));
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}