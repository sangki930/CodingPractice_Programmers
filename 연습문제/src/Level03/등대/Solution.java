package Level03.등대;

import java.util.*;

class Solution {

    static int n;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[][] dp;
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        this.n = n;
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++) {
            int start = lighthouse[i-1][0];
            int end = lighthouse[i-1][1];
            graph[start].add(end);
            graph[end].add(start);
        }
        dfs(1);
        return Math.min(dp[1][0], dp[1][1]);
    }

    static void dfs(int number) {
        visited[number] = true;
        dp[number][0] = 0;
        dp[number][1] = 1;

        for(int child : graph[number]) {
            if(!visited[child]) {
                dfs(child);
                dp[number][0] += dp[child][1];
                dp[number][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
