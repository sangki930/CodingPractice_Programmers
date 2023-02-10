package _05행렬과연산;

import java.util.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int r= rc.length, c = rc[0].length;
        int[][] answer = new int[r][c];
        
        LinkedList<Integer> left_col = new LinkedList<>(), right_col = new LinkedList<>();
        LinkedList<LinkedList<Integer>> rows = new LinkedList<>();
        
        for(int i=0;i<r;i++){
            left_col.offer(rc[i][0]);
            right_col.offer(rc[i][c-1]);
            LinkedList<Integer> deque = new LinkedList<>();
            for(int j=1;j<c-1;j++){
                deque.offerLast(rc[i][j]);
            }
            rows.offer(deque);
        }
        
        for(String op : operations){
            switch(op){
                case "ShiftRow"->{
                    left_col.offerFirst(left_col.pollLast());
                    rows.offerFirst(rows.pollLast());
                    right_col.offerFirst(right_col.pollLast());
                }
                case "Rotate"->{
                    rows.peekFirst().offerFirst(left_col.pollFirst());
                    right_col.offerFirst(rows.peekFirst().pollLast());
                    rows.peekLast().offerLast(right_col.pollLast());
                    left_col.offerLast(rows.peekLast().pollFirst());
                }
            }
        }

        for(int i=0;i<r;i++){
            answer[i][0] = left_col.pollFirst();
        }
        int k=0;
        for(LinkedList<Integer> deque:rows){
            for(int j=1;j<c-1;j++)
                answer[k][j] = deque.pollFirst();
            k++;
        }
        for(int i=0;i<r;i++){
            answer[i][c-1] = right_col.pollFirst();
        }
   
        return answer;
    }    
}