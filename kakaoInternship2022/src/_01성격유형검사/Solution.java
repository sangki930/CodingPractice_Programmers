package _01성격유형검사;

import java.util.*;

class Pair{
    String s;
    int point;
    public Pair(String s, int point){
        this.s=s;
        this.point=point;
    }
}

class Solution {
    Map<String,Integer> scores;
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        scores = new HashMap<>();
        scores.put("R",0);
        scores.put("T",0);
        scores.put("C",0);
        scores.put("F",0);
        scores.put("J",0);
        scores.put("M",0);
        scores.put("A",0);
        scores.put("N",0);
        int n = choices.length;
        for(int i=0;i<n;i++){
            String[] input = survey[i].split("");
            String s1 = input[0], s2 = input[1];
            int choice = choices[i];
            if(1<=choice && choice<=3){
                scores.put(s1,scores.getOrDefault(s1,0)+(4-choice));
            }else if(5<=choice && choice<=7){
                scores.put(s2,scores.getOrDefault(s2,0)+(choice-4));
            }
        }

        answer+=func("R","T");
        answer+=func("C","F");
        answer+=func("J","M");
        answer+=func("A","N");

        return answer;
    }

    public String func(String p1, String p2){
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(p1,scores.getOrDefault(p1,0)));
        list.add(new Pair(p2,scores.getOrDefault(p2,0)));
        list.sort((a,b)->{
            if(a.point==b.point)
                return a.s.compareTo(b.s);
            return Integer.compare(b.point,a.point);
        });
        return list.get(0).s;
    }
}