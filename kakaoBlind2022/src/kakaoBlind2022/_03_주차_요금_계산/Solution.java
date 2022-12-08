package kakaoBlind2022._03_주차_요금_계산;

import java.util.*;

class Data{
    int no;
    long time;
    long accTime;
    long fee;
    public Data(int no,long time, long fee){
        this.no=no;
        this.time=time;
        this.fee=fee;
        this.accTime=0L;
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        // fees[0] : 기본시간, fees[1] : 기본요금, fees[2] : 단위시간, fees[3] : 단위요금
        Map<Integer,Data> map = new TreeMap<>();
        
        for(String rec : records){
            String[] input = rec.split(" ");
            long time = convert(input[0]);
            int no = Integer.parseInt(input[1]);
            switch(input[2]){
                case "IN"->{
                    Data data = map.getOrDefault(no,new Data(no,time,0));
                    if(data.time!=0) data.time=time;
                    map.put(no,data);
                }
                case "OUT"->{
                    Data data = map.getOrDefault(no,new Data(no,time,0));
                    data.accTime+=(time-data.time);
                    data.time=-1L;
                    map.put(no,data);
                }
            }
        }
        answer = new int[map.size()];
        int idx=0;
        for(Data data : map.values()){
            if(data.time!=-1L){
                data.accTime += (convert("23:59")-data.time);
            }   
            answer[idx++] = (int)Math.max(fees[1], fees[1]+Math.ceil((data.accTime-fees[0])/(double)fees[2])*fees[3]);
        }
        return answer;
    }
    // 00:00-> 절대시간으로 바꿈
    public long convert(String s){
        String[] input = s.split(":");
        return Long.parseLong(input[0])*60+Long.parseLong(input[1]);
    }
}