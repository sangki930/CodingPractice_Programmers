package _05_호텔_방_배정;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public long[] solution(long k, long[] room_number) {
        int N = room_number.length;
        long[] answer = new long[N]; 
        
        Map<Long,Long> hm = new HashMap<>();
        
        for(int i=0;i<N;++i){
            
            long x = room_number[i];
            
            if(!hm.containsKey(x)){
                answer[i]=x;
                hm.put(x,x+1);
            }else{
                List<Long> list = new ArrayList<>();
                while(hm.containsKey(x)){
                    list.add(x);
                    x=hm.get(x);
                }
                answer[i]=x;
                list.add(x);
                for(long l:list){
                    hm.put(l,x+1);
                }
            }

        }
    
        return answer;
    }
}