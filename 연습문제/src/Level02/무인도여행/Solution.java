package Level02.무인도여행;

import java.util.*;

class Point{
    int x,y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    
    int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public int[] solution(String[] maps) {
        int[] answer = {};
        LinkedList<Integer> ret = new LinkedList<>();
        int r = maps.length, c = maps[0].length();
        boolean[][] visited = new boolean[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                char v = maps[i].charAt(j);
                if(v=='X' || visited[i][j]) continue;
                LinkedList<Point> queue = new LinkedList<>();
                queue.offer(new Point(i,j));
                visited[i][j] = true;
                int sum = maps[i].charAt(j)-'0';
                while(!queue.isEmpty()){
                    Point point = queue.poll();
                    for(int k=0;k<4;k++){
                      int nx = point.x+dx[k];
                      int ny = point.y+dy[k];
                      if(0<=nx && nx<r && 0<=ny && ny<c && 
                         !visited[nx][ny] && maps[nx].charAt(ny)!='X'){
                          queue.offer(new Point(nx,ny));
                          visited[nx][ny] = true;
                          sum += maps[nx].charAt(ny)-'0';
                      }
                    }
                }
                
                ret.offer(sum);
            }
        }
        if(ret.isEmpty()) return new int[]{-1};
        
        return ret.stream().sorted().mapToInt(i->i).toArray();
    }
}