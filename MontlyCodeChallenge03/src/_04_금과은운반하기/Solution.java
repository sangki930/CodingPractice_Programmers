package _04_금과은운반하기;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long)Math.pow(10,15);
        
        long start = 0, end = (long)Math.pow(10,15)+1;
        while(start <= end){
            long mid = (start+end)/2;
            long gM=0,gm=0,sM=0,sm=0;
            for(int i=0;i<t.length;i++){
                long c = (mid-(long)t[i])/(long)(2*t[i])+1L;
                gM += (g[i] - c * (long)w[i]<=0)?(long)g[i]:c * (long)w[i];
                sm += (g[i] - c * (long)w[i]<=0)?Math.min(s[i], Math.abs(g[i] - c * (long)w[i])):0;
                sM += (s[i] - c * (long)w[i]<=0)?(long)s[i]:c * (long)w[i];
                gm += (s[i] - c * (long)w[i]<=0)?Math.min(g[i], Math.abs(s[i] - c * (long)w[i])):0;
            }
            
            
            if(gM >= a && sM >= b && gM + sm >= a + b){
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
            else
                start = mid + 1;   
        }
        
        return answer;
    }
}
