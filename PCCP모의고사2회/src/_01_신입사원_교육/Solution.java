package _01_신입사원_교육;

import java.util.*;

public class Solution {
    public int solution(int[] ability, int number) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)->a-b
        );
        
        for(int i : ability)
            pq.offer(i);
        
        for(int i=0;i<number;i++){
            int sum = 0;
            for(int j=0;j<2;j++)
                sum+=pq.poll();
            for(int j=0;j<2;j++)
                pq.offer(sum);
        }
        
        while(!pq.isEmpty())
            answer+=pq.poll();
        
        return answer;
    }
}
