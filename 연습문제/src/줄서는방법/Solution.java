package 줄서는방법;

import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long num = 1;
        int i=1;
        for(i=1;i<=n;i++){
            list.add(i);
            num*=i;
        }
        i=0;
        long mod = k-1;
        
        while(i<n){
            num /= (n-i);
            int value = (int)(mod / num);
            answer[i++] = list.get(value);
            list.remove(value);
            mod %= num;
        }
        
        return answer;
    }
}
