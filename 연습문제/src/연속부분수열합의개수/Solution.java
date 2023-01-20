package 연속부분수열합의개수;

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] arr = new int[2*n];
        for(int i=0;i<n;i++) arr[i] = elements[i];
        for(int i=0;i<n;i++) arr[i+n] = elements[i];
        int[] nums = new int[1000001];
        for(int i=0;i<n;i++){
            long sum=0;
            for(int j=i;j<i+n;j++){
                sum+=arr[j];
                nums[(int)sum]++;
            }
        }
        return (int)Arrays.stream(nums).filter(num->num>0).count();
    }
}
