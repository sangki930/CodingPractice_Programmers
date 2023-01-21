package 숫자블록;

class Solution {
    public int[] solution(long begin, long end) {
        int n = (int)(end-begin+1L);
        int[] answer = new int[n];
        
        for(long i=begin,k=0;i<=end;i+=1L,k+=1L){
            if(i==1){
                answer[(int)k] = 0;
                continue;
            }
            answer[(int)k]=1;
            for(int j=2;j<=Math.sqrt(i);j++){
                if((int)i%j==0){
                    if(i/j<=10000000){
                        answer[(int)k] = (int)i/j;
                        break;
                    }
                }  
            }
        }
        
        return answer;
    }
}
