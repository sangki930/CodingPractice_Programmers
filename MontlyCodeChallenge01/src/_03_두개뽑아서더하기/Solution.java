package _03_두개뽑아서더하기;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> result = new HashSet<>();
        
        for(int i=0;i<numbers.length;i++)
            for(int j=i+1;j<numbers.length;j++)
                if(i!=j)
                    result.add(numbers[i]+numbers[j]);
        return result.stream().sorted().mapToInt(i->i).toArray();
    }
}