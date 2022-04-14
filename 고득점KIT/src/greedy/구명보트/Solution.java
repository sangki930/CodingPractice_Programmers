package greedy.구명보트;

import java.util.*;

// 구명보트
class Solution {
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
 
        int answer = 0;
        int index = people.length - 1;
        for(int i = 0; i <= index; i++, answer++) 
            while(index > i && people[i] + people[index--] > limit) 
                answer++;
 
        return answer;
    }
}