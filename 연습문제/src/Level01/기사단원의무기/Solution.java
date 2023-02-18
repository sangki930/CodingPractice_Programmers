package Level01.기사단원의무기;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            int cnt = count(i);
            if(limit<cnt) answer+=power;
            else answer+=cnt;
        }
        return answer;
    }
    public int count(int n){
        if(n==1) return 1;
        int ret = 0;
        for(int i=1;i<=(int)Math.sqrt(n);i++){
            if(n%i==0) ret+=2;
        }
        if(Math.sqrt(n)==(int)Math.sqrt(n))
            ret--;
        return ret;
    }
}
