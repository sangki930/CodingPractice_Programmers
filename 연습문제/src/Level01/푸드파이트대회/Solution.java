package Level01.푸드파이트대회;

class Solution {
    public String solution(int[] food) {
        String answer = "0";
        int len = food.length;
        for(int i=len-1;i>=1;i--){
            int cnt = food[i]/2;
            for(int j=0;j<cnt;j++){
                answer = i + answer + i;
            }
        }
        return answer;
    }
}
