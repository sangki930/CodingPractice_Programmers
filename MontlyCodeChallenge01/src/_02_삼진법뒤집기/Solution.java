package _02_삼진법뒤집기;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String result="";
        while(n>0){
            result+=n%3;
            n/=3;
        }
    
        for(int i=result.length()-1;i>=0;i--){
            answer+=(result.charAt(i)-'0')*(int)Math.pow(3,result.length()-i-1);
        }
        
        return answer;
    }
}
