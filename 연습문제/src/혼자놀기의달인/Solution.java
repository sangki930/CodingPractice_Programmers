package 혼자놀기의달인;

import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        for(int x : cards){
            int[] ch = new int[cards.length];
            Arrays.fill(ch,1);
            int G1 = 0, des = x;
            while(true){
                if(ch[des-1]==1){
                    ch[des-1] = 0;
                    G1+=1;
                    des = cards[des-1];
                }else break;
            }
            List<Integer> arr = new ArrayList<>();
            for(int i=0;i<cards.length;i++){
                if(ch[i]==1)
                    arr.add(cards[i]);
            }
            if(arr.isEmpty()) break;
            int G2 = 0;
            for(int y : arr){
                int tmp2 = 0;
                des = y;
                while(true){
                    if(ch[des-1]==1){
                        ch[des-1] = 0;
                        tmp2+=1;
                        des = cards[des-1];
                    }else{
                        G2 = Math.max(G2,tmp2);
                        break;
                    }
                }
            }
            answer = Math.max(G1*G2,answer);
        }
        
        return answer;
    }
}