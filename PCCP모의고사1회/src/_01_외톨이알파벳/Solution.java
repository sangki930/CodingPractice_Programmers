package _01_외톨이알파벳;

import java.util.*;

class Solution {
    public String solution(String input_string) {
        String answer = "";
        Map<Character,ArrayList<String>> map = new TreeMap<>();
        
        String s = input_string.charAt(0)+"";
        char c = '6';
        for(int i=0;i<input_string.length()-1;i++){
            c = input_string.charAt(i);
            if(c==input_string.charAt(i+1)){
                s+=input_string.charAt(i+1);
            }else{
                ArrayList<String> arr = map.getOrDefault(c,new ArrayList<>());
                arr.add(s);
                map.put(c,arr);
                s = input_string.charAt(i+1)+"";
                c = input_string.charAt(i+1);
            }
        }
        
        ArrayList<String> arr1 = map.getOrDefault(c,new ArrayList<>());
        arr1.add(s);
        map.put(c,arr1);
        
        for(char ch : map.keySet()){
            ArrayList<String> arr = map.getOrDefault(ch,new ArrayList<>());
            if(arr.size()>=2)
                answer+=ch;
        }
        if(answer.isBlank()) return "N";
        return answer;
    }
}