package 충돌위험찾기;

import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        int[][] board = new int[101][101];
        Map<Integer,Integer>[][] board_map = new HashMap[101][101];

        for(int i=0;i<=100;i++)
            for(int j=0;j<=100;j++)
                board_map[i][j] = new HashMap<>();

        for(int[] route : routes){
            int k = 1;
            for(int i=0;i<route.length;i++){

                int[] s = points[route[i]-1];
                if(i==route.length-1){
                    board_map[s[0]][s[1]].put(k,board_map[s[0]][s[1]].getOrDefault(k,0)+1);
                    continue;
                }

                int[] e = points[route[i+1]-1];
                // 행 방향으로 이동
                if(s[0]<=e[0]){
                    for(int j=s[0];j<=e[0]-1;j++,k++){
                        board_map[j][s[1]].put(k,board_map[j][s[1]].getOrDefault(k,0)+1);
                    }
                }else{
                    for(int j=s[0];j>=e[0]+1;j--,k++){
                        board_map[j][s[1]].put(k,board_map[j][s[1]].getOrDefault(k,0)+1);
                    }
                }
                // 열 방향으로 이동
                if(s[1]<=e[1]){
                    for(int j=s[1];j<=e[1]-1;j++){
                        board_map[e[0]][j].put(k,board_map[e[0]][j].getOrDefault(k,0)+1);
                        k++;
                    }
                }else{
                    for(int j=s[1];j>=e[1]+1;j--){
                        board_map[e[0]][j].put(k,board_map[e[0]][j].getOrDefault(k,0)+1);
                        k++;
                    }
                }
            }
        }

        for(int i=0;i<=100;i++){
            for(int j=0;j<=100;j++){
                Map<Integer,Integer> map = board_map[i][j];
                for(int k : map.keySet()){
                    if(map.get(k)>=2) answer++;
                }
            }
        }
        return answer;
    }
}