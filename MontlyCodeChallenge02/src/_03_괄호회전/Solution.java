package _03_괄호회전;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char ch[]=s.toCharArray();
        
        for(int i=0;i<s.length();i++){
            Stack<Character> stack = new Stack<>();
            for(int j=i;j<i+s.length();j++){
                
                if(stack.isEmpty()){
                    stack.push(ch[j%s.length()]);
                }else{
                    char p = stack.peek();
                    switch(p){
                        case '('->{
                            if(ch[j%s.length()]==')')
                                stack.pop();
                            else
                                stack.push(ch[j%s.length()]);
                        }
                        case '{'->{
                            if(ch[j%s.length()]=='}')
                                stack.pop();
                            else
                                stack.push(ch[j%s.length()]);
                        }
                        case '['->{
                            if(ch[j%s.length()]==']')
                                stack.pop();
                            else
                                stack.push(ch[j%s.length()]);
                        }
                        default->{
                            stack.push(ch[j%s.length()]);
                        }
                    }
                }
                
            }
            if(stack.isEmpty()) answer++;
        }
        
        return answer;
    }
}
