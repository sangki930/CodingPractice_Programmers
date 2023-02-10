package _02두큐합같게만들기;

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        boolean flag1 = false, flag2 = false;
        LinkedList<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>()
        ,q3 = new LinkedList<>(), q4 = new LinkedList<>();
        long sum_q1 = 0, sum_q2 = 0, sum_q3 = 0 ,sum_q4 = 0;
        for(int i=0;i<queue1.length;i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            q3.offer(queue1[i]);
            q4.offer(queue2[i]);
            sum_q1+=queue1[i];
            sum_q2+=queue2[i];
            sum_q3+=queue1[i];
            sum_q4+=queue2[i];
        }
        if((sum_q1+sum_q2)%2==1) return -1;
        long target = (sum_q1+sum_q2)/2;

        // queue2=>queue1
        int cnt=0, size = q2.size();
        while(size-->0){
            if(sum_q1 == target){
                flag1 = true;
                break;
            }
            
            
            while(!q2.isEmpty() && sum_q1<target){
                int v = q2.poll();
                cnt++;
                sum_q1+=v;
                q1.offer(v);
            }
            
            while(!q1.isEmpty() && sum_q1>target){
                sum_q1-=q1.poll();
                cnt++;
            }     
        }

        answer = cnt;
        cnt=0;size = q3.size();
        while(size-->0){
            if(sum_q4 == target){
                flag2 = true;
                break;
            }
            while(!q3.isEmpty() && sum_q4<target){
                int v = q3.poll();
                cnt++;
                sum_q4+=v;
                q1.offer(v);
            }
            
            while(!q4.isEmpty() && sum_q4>target){
                sum_q4-=q4.poll();
                cnt++;
            }
        }

        if(!flag1 && !flag2) return -1;
        return Math.min(flag1?answer:Integer.MAX_VALUE,flag2?answer:Integer.MAX_VALUE);
    }
}
