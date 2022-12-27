package _02_튜플;

import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        s=s.substring(1, s.length()-1);
        StringTokenizer st = new StringTokenizer(s,"{}");
        List<List<String>> tuple = new ArrayList<>();
        while(st.hasMoreTokens()) { 
            String token = st.nextToken();
            if(token.equals(",")){
                continue;
            }
            String temp[] = token.split(",");
            List<String> list = Arrays.asList(temp);
            tuple.add(list); 
        }
        tuple.sort((a,b)->{
            return a.size()-b.size();
        });
        
        List<String> result = new ArrayList<>();
        for(List<String> t : tuple){
            for(String str:t){
                if(!result.contains(str)){
                    result.add(str);
                }
            }
            
        }

       int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=Integer.parseInt(result.get(i));
        }
        
        return answer;
    }
}