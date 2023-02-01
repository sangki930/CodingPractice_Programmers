package _04_삼각달팽이;

import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][];
        int total = n*(n+1)/2;
        for(int i=1;i<=n;i++){
            int[] tmp = new int[i];
            arr[i-1]=tmp;
        }
        int num=1;
        int i=0,j=0;
        int diagonal=n-1;
        while(num<=total){
            
            for(int k=0;k<n;k++){
                if(num>total)
            		break;
                answer[1+(j*(j+1)/2)+i-1]=arr[j][i]=num;
                j++;
                num++;
            }n--;j--;i++;
            for(int k=0;k<n;k++){
                if(num>total)
            		break;
                answer[1+(j*(j+1)/2)+i-1]=arr[j][i]=num;
                
                i++;
                num++;
            }n--;j--;i-=2;
            
            
            for(int k=0;k<n;k++){
                if(num>total)
            		break;
                answer[1+(j*(j+1)/2)+i-1]=arr[j][i]=num;
                num++;j--;i--;
            }j+=2;n--;i++;
            
        } 
        return answer;
    }
}
