package _03_카페확장;

import java.util.*;

class Data{
    int start;
    int end;
    public Data(int start,int end){
        this.start=start;
        this.end=end;
    }
    
    @Override
    public String toString(){
        return "{ start : "+start+", end : "+end+" }";
    }
}

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int answer = 1;
        int[] times = new int[order.length+1];
        times[0] = Math.max(menu[order[0]],k);
        for(int i=1;i<order.length;i++){
            times[i]=Math.max(times[i-1]+menu[order[i]],(i+1)*k);
        }
        times[times.length-1] = 20000000;
        LinkedList<Data> queue = new LinkedList<>();
        int pre = 0, next = times[0];
        int j = 0;
        for(int i=0;i<times.length-1;i++){
            queue.poll();
            while(j<order.length && pre<=j*k && j*k<next){
                queue.offer(new Data(j*k,times[j]));
                j++;
            }
            pre = times[i];
            next = times[i+1];
            answer = Math.max(answer,queue.size());
        }
        
        return answer;
    }
}
