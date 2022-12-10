package _01_크레인_인형뽑기_게임;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
       Stack<Integer> bucket = new Stack<>();
        
        for(int move :  moves){
            int doll=0;
            
            for(int i=0;i<board.length;i++){
            if(board[i][move-1]!=0){
                doll = board[i][move-1];
                board[i][move-1]=0;
                break;
            }
        }
            
           if(doll>0)
                bucket.push(doll);
                
            if(bucket.size()>=2){
                int peek = bucket.pop();
                int sec  = bucket.pop();
                if(peek!=sec){
                    bucket.push(sec);
                    bucket.push(peek);
                    
                    continue;
                }
                answer+=2;
                
            }
                
        }
        return answer;
    }
}
