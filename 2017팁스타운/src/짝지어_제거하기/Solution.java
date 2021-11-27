package 짝지어_제거하기;

import java.util.*;
class Solution
{
    static String str;
    public int solution(String s)
    {
        int answer = 0;
        
        str = new String(s);
        char ch [] =s.toCharArray();
       
        Stack<Character> stack =new Stack<>();
        
        int idx=0;
        for(char c : ch){
            if(idx==0)
            {
                stack.push(ch[idx++]);
                continue;
            }
           if(stack.isEmpty()){
               stack.push(c);
               continue;
           }
            if(stack.peek()==c){
                 if(!stack.isEmpty()){
                     stack.pop();
                 }
            }else{
                stack.push(c);
            }
            
        }
       
        
        return stack.isEmpty()?1:0;
    }
}