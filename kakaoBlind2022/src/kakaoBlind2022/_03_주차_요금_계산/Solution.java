package kakaoBlind2022._03_주차_요금_계산;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = new Integer(n).toString(n,k);
        StringBuilder sb = new StringBuilder("");
            for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0'){
                if(sb.toString().length()>0 && isPrimeNumber(Long.parseLong(sb.toString()))){
                    answer++;
                }
                sb = new StringBuilder();
            }else{
                sb.append(str.charAt(i));
            }
        }
           if(sb.toString().length()>0 && isPrimeNumber(Long.parseLong(sb.toString()))){
            answer++;
           }
          return answer;
    }
    
    public boolean isPrimeNumber(long n){
        if(n==1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        
        return true;
    }
}