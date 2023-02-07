package kakaoBlind2023._03_이모티콘할인행사;

import java.util.*;

class Solution {
    
    double[] rates = {0.1,0.2,0.3,0.4};
    int[][] users;
    int[] emoticons;
    int[] answer = {0,0};
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        this.users=users;
        this.emoticons=emoticons;
        int len = emoticons.length;
        func(new ArrayList<>(),0,4,len);
        return answer;
    }
    
    public void func(List<Integer> list, int idx, int n, int m){
        
        if(m==idx){
            int person = 0;
            int sell = 0;
            for(int[] user : users){
                double rate = user[0]/100.0;
                int sum = 0;
                for(int i=0;i<list.size();i++){
                    int j = list.get(i);
                    double t = rates[j];
                    if(t<rate) continue;
                    sum+=(emoticons[i]*(1-t));
                }
                if(sum>=user[1]){
                    person++;
                    sum = 0;
                }else{
                    sell+=sum;
                }
            }
            
            if(person>answer[0]){
                answer = new int[]{person,sell};
            }else if(person==answer[0]){
                answer[1] = Math.max(sell,answer[1]);
            }
            
            return ;
        }
        
        for(int i=0;i<n;i++){
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(i);
            func(tmp,idx+1,n,m);
        }
        
    }
}