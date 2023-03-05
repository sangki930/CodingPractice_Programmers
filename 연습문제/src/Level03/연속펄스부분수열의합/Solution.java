package Level03.연속펄스부분수열의합;

import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        return Math.max(solution(sequence,1),solution(sequence,-1));
    }

    public long solution(int[] arr, int start){
        int n = arr.length;
        int[] tmp = new int[n];
        for(int i=0;i<n;i++){
            if(i%2==0)
                tmp[i] = start*arr[i];
            else
                tmp[i] = -start*arr[i];
        }
        long[] acc = new long[n+1];
        for(int i=1;i<=n;i++)
            acc[i] = acc[i-1]+tmp[i-1];
        long max = acc[0], min = acc[0];
        long ret = Long.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(min>acc[i]){
                ret = Math.max(ret,acc[i]-min);
                max = acc[i];
                min = acc[i];
            }else if(max<=acc[i]){
                max = acc[i];
                ret = Math.max(ret,max-min);
            }
        }
        return ret;
    }
}