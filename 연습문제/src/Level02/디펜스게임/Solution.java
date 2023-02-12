package Level02.디펜스게임;

import java.util.*;

// Level02
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        int len = enemy.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for(int i=0;i<len;i++){
            int v = enemy[i];
            if(pq.size()<k){
                pq.offer(v);
            }else if(pq.size()==k){
                int num = pq.peek();
                if(num<v){
                    int tmp = pq.poll();
                    sum+=tmp;
                    pq.offer(v);
                }else{
                    sum+=v;
                }
            }
            if(sum>n){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}