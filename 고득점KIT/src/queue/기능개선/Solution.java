package queue.기능개선;

import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> progresslist
            =Arrays.stream(progresses).boxed().collect(Collectors.toList());
        List<Integer> speedlist
            =Arrays.stream(speeds).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        
        int time=1;
        while(!progresslist.isEmpty()){
            for(int i=0;i<progresslist.size();i++){
                progresslist.set(i,progresslist.get(i)+speedlist.get(i));
            }
            int cnt=0;
            while(progresslist.get(0)>=100){
                progresslist.remove(0);
                speedlist.remove(0);
                cnt++;
                if(progresslist.isEmpty())
                	break;
            }
            if(cnt>0)
            result.add(cnt);
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}
