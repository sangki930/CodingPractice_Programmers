package 억억단을외우자;

import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] test = new int[e+2];
        test[e+1] = e+1;
        int p = func(e);
        for(int i=e;i>=1;i--){
            int v = func(i);
            // System.out.println(v);
            if(p<=v){
                test[i] = i;
                p=Math.max(p,v);
            }else{
                test[i] = test[i+1];
            }
            // System.out.println(Arrays.toString(test));
        }

        for(int i=0;i<starts.length;i++){
            answer[i] = test[starts[i]];
        }

        return answer;
    }

    public int func(int N){
        if(N==1) return 1;
        Map<Integer,Integer> counter = new HashMap<>();
        int ret = 1;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                // System.out.println(i);
                counter.put(i,counter.getOrDefault(i,0)+1);
                N /= i;
            }
        }
        if (N != 1) {
            // System.out.println(N);
            counter.put(N,counter.getOrDefault(N,0)+1);
        }
        for(int key : counter.keySet()){
            ret*=(counter.get(key)+1);
        }
        return ret;
    }
}
