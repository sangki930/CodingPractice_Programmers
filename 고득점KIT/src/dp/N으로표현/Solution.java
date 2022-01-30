package dp.N으로표현;

import java.util.*;
class Solution {

    static int _N;
    TreeSet<Integer>[] dynamic;

    public TreeSet<Integer> solve(int n) {
        if ((dynamic[n]!=null) &&!dynamic[n].isEmpty()) return dynamic[n];//전에 있던 집합 찾기.
        int num = 0;
        for (int i = 0; i < n; i++) num = 10 * num + _N; // NNNN만들기.
        TreeSet<Integer> temp = new TreeSet<>();
        temp.add(num);
        for(int i =1; i<n;i++){
            int j = n-i;
            TreeSet<Integer> from = solve(i);
            TreeSet<Integer> to = solve(j);
            for(int n1:from) {
                for (int n2 : to) {//d[n] = d[n-1] + d[i];
                    temp.add(n1 + n2);
                    temp.add(n1 - n2);
                    temp.add(n1 * n2);
                    if(n2 != 0) temp.add(n1 / n2);
                }
            }
        }
        return dynamic[n]= temp;
    }


    public int solution(int N, int number) {
        int answer = 0;
        _N = N;

        dynamic = new TreeSet[10];
        for(int i =1 ; i<= 8; i++){
            solve(i);
            if (dynamic[i].contains(number)) return i;
        }
        return -1;
    }

}