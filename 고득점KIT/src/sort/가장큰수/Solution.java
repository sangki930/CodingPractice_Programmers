package sort.가장큰수;

import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] numbers) {
        if(numbers.length==1)
            return numbers[0]+"";
        String answer = answer = Arrays.stream(numbers)
			.mapToObj(i->String.valueOf(i))
			.sorted((a,b)->(b+a).compareTo(a+b))
			.collect(Collectors.joining());
       
        return answer.charAt(0)=='0'?"0":answer;
    }
}
