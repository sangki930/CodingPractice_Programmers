package _06_n제곱_배열_자르기;

class Solution {
    public int[] solution(int n, long left, long right) {
        int cnt = (int)(right-left)+1;
        int[] answer = new int[cnt];
        for(int i=0;i<cnt;i++){
            long j = (left+i);
            long row = j/n+1;
            long col = j%n+1;
            answer[i]=(int)Math.max(row,col);
        }
        return answer;
    }
}
