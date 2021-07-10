package Problem01;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        List<Integer> list = Arrays.stream(win_nums)
                                   .boxed()
                                   .collect(Collectors.toList());
        
        int cnt=0;
        int zeros=0;
        
        for(int i : lottos){
            if(i==0){
                zeros++;
                continue;
            }
            if(list.contains(i))
            {
                cnt++;
            }
        }
        answer[0]=(cnt+zeros)<=1?6:7-(cnt+zeros);
        answer[1]=(cnt<=1)?6:7-cnt;
        return answer;
    }
}
