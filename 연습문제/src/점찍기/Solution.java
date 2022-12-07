package 점찍기;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(long i=0;i<d+1;i+=k){
            long y = (long)Math.pow((long)d*(long)d-i*i,0.5);
            answer += (y/k+1);
        }
        return answer;
    }
}