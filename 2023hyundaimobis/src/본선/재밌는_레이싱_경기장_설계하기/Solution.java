package 본선.재밌는_레이싱_경기장_설계하기;

import java.util.*;

class Solution {
    public int solution(int[] heights) {
        Arrays.sort(heights);
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[(heights.length+1)/2];
        for (int i=0,j=0; i<heights.length/2; i++,j++){
            arr[j] = heights[i+heights.length/2]-heights[i];
        }
        if(heights.length%2==1){
            arr[arr.length-1] = heights[heights.length-1]-heights[heights.length/2];
            Arrays.sort(arr);
            return arr[1];
        }
        Arrays.sort(arr);
        return arr[0];
    }
}