package Level03.인사고과;

import java.util.*;

class Person{
    int id,a,b;
    public Person(int id, int a, int b){
        this.id=id;
        this.a=a;
        this.b=b;
    }
    
    @Override
    public String toString(){
        return "{ id : "+this.id+", a : "+this.a+",b : "+this.b+" }";
    }
}
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        List<Person> list = new ArrayList<>();
        List<Person> scorelist = new ArrayList<>();
        
        TreeMap<Integer,ArrayList<Person>> scoremap = new TreeMap<>((a,b)->b-a);
        
        for(int i = 0;i < scores.length ; i++){
            int[] score = scores[i];
            int a = score[0]; // 자신의 점수
            int b = score[1]; // 남이 매긴 점수
            ArrayList<Person> tmp = scoremap.getOrDefault(a,new ArrayList<>());
            tmp.add(new Person(i,a,b));
            scoremap.put(a,tmp);
        }

        int prev_max = Integer.MIN_VALUE;
        for(int a : scoremap.keySet()){
            ArrayList<Person> tmp = scoremap.getOrDefault(a,new ArrayList<>());
            int max = -1;
            for(Person person : tmp){
                if(person.b>=prev_max)
                    scorelist.add(person);
                max = Math.max(person.b,max);
            }
            prev_max = Math.max(prev_max,max);
        }
        
        int a_cnt = 0;
        int b_cnt = 0;
        boolean flag = false;
        TreeMap<Integer,ArrayList<Person>> map = new TreeMap<>((a,b)->b-a);
        for(int i = 0 ; i < scorelist.size() ; i++){
            Person first = scorelist.get(i);
            int[] score = {first.a,first.b};
            if(first.id==0) flag = true;
            ArrayList<Person> arr = map.getOrDefault(score[0]+score[1],new ArrayList<>());
            arr.add(new Person(first.id,score[0],score[1]));
            map.put(score[0]+score[1],arr);
        }
        if(!flag) return -1; // 완호가 인센티브를 받지 못하면

        int prev = -1;
        for(int total : map.keySet()){
            ArrayList<Person> arr = map.getOrDefault(total,new ArrayList<>());
            for(Person person : arr){
                if(person.id==0) return answer;
            }
            answer+=arr.size();
            prev = total;
        }
        
        return answer;
    }
}
