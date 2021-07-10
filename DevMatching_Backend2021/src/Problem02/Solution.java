package Problem02;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] board=new int[rows][columns];
        
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++)
                board[i][j] = i*columns+j+1;
        int idx=0;
        for(int query[] : queries){
            
            int r_s=query[0]-1;
            int c_s=query[1]-1;
            int r_e=query[2]-1;
            int c_e=query[3]-1;
            
            Deque<Integer> list = new LinkedList<>();
            int min = 10000;
            for(int i=c_s;i<c_e;i++){
                list.add(board[r_s][i]);
                min = Math.min(board[r_s][i],min);
            }
            for(int i=r_s;i<r_e;i++){
                list.add(board[i][c_e]);
                min = Math.min(board[i][c_e],min);
            }
            for(int i=c_e;i>=c_s+1;i--){
                list.add(board[r_e][i]);
                min = Math.min(board[r_e][i],min);
            }
            for(int i=r_e;i>=r_s+1;i--){
                list.add(board[i][c_s]);
                min = Math.min(board[i][c_s],min);
            }
            // System.out.println(list);
            list.offerFirst(list.pollLast());
            // System.out.println(list);
            for(int i=c_s;i<c_e;i++){
                board[r_s][i]=list.poll();
            }
            for(int i=r_s;i<r_e;i++){
                board[i][c_e]=list.poll();
            }
            for(int i=c_e;i>=c_s+1;i--){
                board[r_e][i]=list.poll();
            }
            for(int i=r_e;i>=r_s+1;i--){
                board[i][c_s]=list.poll();
            }
            
            answer[idx++]=min;
        }
        
        return answer;
    }
}
