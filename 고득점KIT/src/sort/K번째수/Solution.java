package sort.K��°��;

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
        // System.out.println("i�� : "+i+" j�� : "+j);
        // System.out.println("�޼ҵ� ���� array : "+Arrays.toString(array));
        for(int a=i-1;a<=j-1;a++){
            // System.out.println("index �� : " + index);
            // System.out.println("array �� : "+array[a]);
            arrnum[index] = array[a];
            index++;
            
            // System.out.println("���� Array : "+ Arrays.toString(arrnum));
        }
        
        Arrays.sort(arrnum);
        // System.out.println(Arrays.toString(arrnum));
        return arrnum[k-1];
    }
}
