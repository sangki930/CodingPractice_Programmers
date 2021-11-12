package _02_빛의경로사이클;

import java.util.LinkedList;

//
class Solution {
    //https://prgms.tistory.com/101
    int r,c;
    int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    boolean[][][] visited;
    String[] grid;
    public int[] solution(String[] grid) {
        LinkedList<Integer> answer = new LinkedList<>();
        this.grid=grid;
        
        r=grid.length;
        c=grid[0].length();
        visited = new boolean[r][c][4];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                for(int k=0;k<4;k++)
                    if(!visited[i][j][k])
                        answer.offer(move(i,j,k));
        
        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }
    
    public int move(int i, int j, int k){
        int cnt=0;
        while (true) {
            if (visited[i][j][k])
                break;
 
            cnt++;
            visited[i][j][k] = true;
 
            if (grid[i].charAt(j) == 'L')
                k = k == 0 ? 3 : k - 1;
            else if (grid[i].charAt(j) == 'R')
                k = k == 3 ? 0 : k + 1;
 
            i = (i + dx[k] + r) % r;
            j = (j + dy[k] + c) % c;
        }
 
        return cnt;
    }
}
