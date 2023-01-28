package kakaoBilnd2019._04무지의먹방라이브;

import java.util.*;

class Solution {
    class Food{
        int time;
        int idx;
        Food(int t,int i){
            time=t;
            idx=i;
        }
    };
    
  
    
    public int solution(int[] food_times, long k) {
        // int answer = 0;
        List<Food> foods = new LinkedList<>();
        
        int n = food_times.length;
        
        for(int i=0;i<n;++i){
            foods.add(new Food(food_times[i],i+1));
        }
        
        foods.sort(
            (a, b)->
            {return a.time-b.time;}
        );
        
        int pretime=0;//이전시간
        int i=0;
        
        for(Food f : foods){
            long diff = f.time - pretime;
            if(diff !=0){
                long spend = diff *n;
                if(spend<=k){
                    k-=spend;
                    pretime =f.time;
                }else{
                    k%=n;
                    
                    foods.subList(i, food_times.length)
                        .sort((Food a, Food b)->
            a.idx-b.idx);
                    
                    
                    return foods.get(i+(int)k).idx;
                }
            }
            ++i;
            --n;
        }
        
        return -1;
    }
}
