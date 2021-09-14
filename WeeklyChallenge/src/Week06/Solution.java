package Week06;

import java.util.*;

class Boxer{
    int id;
    int weight;//복서의 체중
    int v;// 자기보다 무거운 복서를 이긴 횟수
    int plays;//경기 횟수
    int victory;// 이긴 횟수
    double rate;//승률
    public Boxer(int id, int weight, int v, int victory, int plays){
        this.id=id;
        this.weight=weight;
        this.v=v;
        this.victory=victory;
        this.plays=plays;
        this.rate=plays==0?0.0:(double)victory/(double)plays;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.append("[ ").append("id").append(" : ").append(this.id).append(", ")
                 .append("weight").append(" : ").append(this.weight).append(", ")
                 .append("v").append(" : ").append(this.v).append(", ")
                 .append("victory").append(" : ").append(this.victory).append(", ")
                 .append("plays").append(" : ").append(this.plays).append(", ")
                 .append("rate").append(" : ").append(this.rate).append(" ]").toString();
    }
}

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        int n = weights.length;
        int[] answer = new int[n];
        List<Boxer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int none = 0;
            int v = 0;
            int victory = 0;
            int defeat = 0;
            int id=i+1;
            int weight=weights[i];
            for(int j=0;j<head2head[i].length();j++){
                char c = head2head[i].charAt(j);
                switch(c){
                    case 'W'->{
                        victory++;
                        if(weight<weights[j]) v++;
                    }
                    case 'L'->defeat++;
                    case 'N'->none++;
                }
            }
            list.add(new Boxer(id,weight,v,victory,victory+defeat));
        }
        
        list.sort((a,b)->{
            if(a.rate==b.rate){
                if(a.v==b.v){
                    if(a.weight==b.weight)
                        return Integer.compare(a.id,b.id);
                    return Integer.compare(b.weight,a.weight);
                }
                return Integer.compare(b.v,a.v);
            }
            return Double.compare(b.rate,a.rate);
        });
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i).id;
        }
        
        return answer;
    }
}
