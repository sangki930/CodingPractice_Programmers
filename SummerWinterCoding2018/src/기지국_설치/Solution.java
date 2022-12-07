package 기지국_설치;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start=1;
        for(int station : stations){
            int left = station-w, right = station+w;
            answer+=Math.ceil((double)Math.max(left-start,0)/(2*w+1));
            start = right+1;
        }
        answer+=Math.ceil((double)(n+1-start)/(2*w+1));
        
        return answer;
    }
}