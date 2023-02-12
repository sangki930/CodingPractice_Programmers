package Level02.호텔대실;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] cnt = new int[60*24+10];
        for(String[] time : book_time){
            int start = convert(time[0]), end = convert(time[1]);
            for(int i=start;i<end+10;i++){
                cnt[i]++;
                answer = Math.max(answer,cnt[i]);
            }
        }
        return answer;
    }
    
    public int convert(String time){
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
    }
}
