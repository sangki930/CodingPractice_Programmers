package Week11;

import java.util.*;

class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,1},{1,1},{-1,-1},{1,-1}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 99999999;
        int[][] sq = new int[102][102]; // 지도를 명확하게 보기 위해 2배 늘림
        characterX*=2;
        characterY*=2;
        itemX*=2;
        itemY*=2;
        for(int[] p : rectangle){
            for(int j=p[1]*2;j<=p[3]*2;j++)
                for(int i=p[0]*2;i<=p[2]*2;i++)
                    sq[j][i]=1;
        }
        LinkedList<int[]> list = new LinkedList<>();
        for(int i=2;i<101;i++)
            for(int j=2;j<101;j++){
                if(sq[i][j]==0) continue;
                boolean flag=false;
                for(int k=0;k<dir.length;k++)
                    if(sq[i+dir[k][1]][j+dir[k][0]]==0){
                        flag=true;
                        break;
                    }
                if(flag){
                    // answer++;
                    continue;
                }
                list.offer(new int[]{j,i});
            }
        
        while(!list.isEmpty()){
            int[] a = list.poll();
            sq[a[1]][a[0]]=0;
        } // 도형 안을 비움
        // 여기까지가 지도그리기
        Stack<int[]> stack = new Stack<>();
        boolean visited[][]=new boolean[102][102];
        stack.push(new int[]{characterX, characterY,0});
        
        int total=0;
        //dfs
        while(!stack.isEmpty()){
            
            int[] p = stack.pop();
            
            if((p[0]==itemX && p[1]==itemY) ){
                answer=Math.min(p[2]+1,answer);
                continue;
            }
            if(visited[p[1]][p[0]]) continue;
            
            visited[p[1]][p[0]]=true;
            for(int i=0;i<4;i++){
                int nx = p[0]+dir[i][0];
                int ny = p[1]+dir[i][1];
               
                if(sq[ny][nx]==1){
                    stack.push(new int[]{nx,ny,p[2]+1});
                }
            }
            
        }
        
        return answer/2;
    }
}
