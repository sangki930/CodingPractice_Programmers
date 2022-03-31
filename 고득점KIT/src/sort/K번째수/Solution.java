package sort.K번째수;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // System.out.println("array :" + Arrays.toString(array));
        
        for(int i=0;i<commands.length;i++){
             answer[i]
                 =resultsort(commands[i][0],commands[i][1],commands[i][2],array);
        }

        return answer;
    }
    
    public int resultsort(int i,int j,int k,int[] array){
        int[] arrnum = new int[(j-i)+1];
        int index=0;
        // System.out.println(j-i+1);
        // System.out.println("i값 : "+i+" j값 : "+j);
        // System.out.println("메소드 내의 array : "+Arrays.toString(array));
        for(int a=i-1;a<=j-1;a++){
            // System.out.println("index 값 : " + index);
            // System.out.println("array 값 : "+array[a]);
            arrnum[index] = array[a];
            index++;
            
            // System.out.println("현재 Array : "+ Arrays.toString(arrnum));
        }
        
        Arrays.sort(arrnum);
        // System.out.println(Arrays.toString(arrnum));
        return arrnum[k-1];
    }
}
