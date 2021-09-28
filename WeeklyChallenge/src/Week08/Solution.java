package Week08;

import java.util.*;

class Solution {
    public int solution(int[][] sizes) {

        int row=0,col=0;
        for(int size[]:sizes){
            row=Math.max(row, Math.max(size[0],size[1]));
            col=Math.max(col, Math.min(size[0],size[1]));
        }
        
        return row*col;
    }
}
