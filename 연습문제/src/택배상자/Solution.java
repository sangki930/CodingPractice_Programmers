package 택배상자;

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> queue = new LinkedList<>();
        
        int num = 1, idx = 0;
        loop : while(num<=order.length && idx<order.length){
            while(true){
                if(num>order.length) break;
                if(num==order[idx]){
                    answer++;
                    idx++;num++;
                    break;
                }
                stack.push(num++);
            }
            
            while(!stack.isEmpty() && idx<order.length){
                int l = stack.peek();
                if(l==order[idx]){
                    stack.pop();
                    answer++;
                    idx++;
                    continue;
                }
                break;
            }
            
        }

        return answer;
    }
}
