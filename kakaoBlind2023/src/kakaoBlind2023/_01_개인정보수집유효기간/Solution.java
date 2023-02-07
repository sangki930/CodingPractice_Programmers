package kakaoBlind2023._01_개인정보수집유효기간;

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        LinkedList<Integer> ret = new LinkedList<>();
        
        Map<String,Integer> termMap = new HashMap<>();
        for(String term : terms){
            String[] tmp = term.split(" ");
            termMap.put(tmp[0],Integer.parseInt(tmp[1]));
        }
        String[] tmp;
        int[] days = new int[1000001];
        int id = 0;
        int to = convert(today);
        for(String privacy : privacies){
            tmp = privacy.split(" ");
            int start = convert(tmp[0]);
            int day = termMap.getOrDefault(tmp[1],0)*28-1;
            if(start+day<to){
                ret.offer(id+1);
            }
            id++;
        }
        
        return ret.stream().mapToInt(i->i).toArray();
    }
    
    public int convert(String date){
        String[] tmp = date.split("\\.");
        return Integer.parseInt(tmp[0])*28*12+Integer.parseInt(tmp[1])*28
            +Integer.parseInt(tmp[2]);
    }
    
}