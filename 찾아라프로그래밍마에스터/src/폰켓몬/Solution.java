package 폰켓몬;

import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] nums) {
	        int answer = 0;
	        
	        Set<Integer> set =  Arrays.stream(nums)
	        		.boxed()
	        		.collect(Collectors.toSet());

	        return answer = set.size()>nums.length/2?nums.length/2:set.size();
	    }

}
