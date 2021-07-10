package Problem03;

import java.util.*;

public class Solution {
    Map<String,String> map;
    Map<String,Integer> dict;
    int[] answer;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        map = new HashMap<>();
        dict = new HashMap<>();
        answer = new int[enroll.length];
        for(int i=0;i<enroll.length;i++){
            map.put(enroll[i],referral[i]);
        }
        
        for(int i=0;i<seller.length;i++){
            find(seller[i],amount[i]*100);
        }
        
        for(int i=0;i<enroll.length;i++){
            answer[i]=dict.getOrDefault(enroll[i],0);
        }
        
        return answer;
    }
    
    public void find(String node, int a){
        String root = map.getOrDefault(node,"-");
        int t=a-(int)(a*0.1);
        dict.put(node,t+dict.getOrDefault(node,0));
        if(root.equals("-")){
            return;
        }
        find(root,(int)(a*0.1));
    }
}
