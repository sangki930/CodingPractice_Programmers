package ±Ö°í¸£±â;

import java.util.*;

class Data{
    int size;
    int cnt;
    public Data(int size, int cnt){
        this.size=size;
        this.cnt=cnt;
    }
}

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer,Integer> counter = new HashMap<>();
        PriorityQueue<Data> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.cnt==b.cnt)
                    return Integer.compare(a.size,b.size);
                return Integer.compare(b.cnt,a.cnt);
            }
        );
        for(int i : tangerine){
            counter.put(i,counter.getOrDefault(i,0)+1);
        }
        for(int key : counter.keySet()){
            pq.offer(new Data(key,counter.get(key)));
        }
        answer = pq.size();
        int idx=1;
        while(!pq.isEmpty()){
            k-=pq.poll().cnt;
            if(k<=0) return idx;
            idx++;
        }
        
        return answer;
    }
}
