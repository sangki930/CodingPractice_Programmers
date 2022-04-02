package sort.K¹øÂ°¼ö;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++){
             answer[i]
                 =resultsort(commands[i][0],commands[i][1],commands[i][2],array);
        }

        return answer;
    }
    
    public int resultsort(int i,int j,int k,int[] array){
        int[] arrnum = new int[(j-i)+1];
        int index=0;
        for(int a=i-1;a<=j-1;a++){
            arrnum[index] = array[a];
            index++;
        }
        Arrays.sort(arrnum);
        return arrnum[k-1];
    }
}
