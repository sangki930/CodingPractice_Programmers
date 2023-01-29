package _03_유전법칙;

import java.util.*;

class Solution {
    int[] cong={0,0,1,1,2};
    public String[] solution(int[][] queries) {
       LinkedList<String> result = new LinkedList<>();
        for (int i=0; i<queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];

            if (a == 1){
                result.offer("Rr");
                continue;
            }

            int n = dfs(a,b);

            if (n == 0)
                result.offer("RR");
            else if (n == 2)
                result.offer("rr");
            else
                result.offer("Rr");

        }
        
        return result.toArray(String[]::new);
    }
    
    public int dfs(int a, int b){
    
        if (a == 2){
            return cong[b];
        }

        int x = b/4;
        int y = b%4;
        if (y!=0)
            x++;

        int n = dfs(a-1,x);

        if (n == 0)
            return 0;
        else if (n == 2)
            return 2;
        else {
            if (y == 1)
                return 0;
            else if (y == 0)
                return 2;
            else
                return 1;
        }
    }

}