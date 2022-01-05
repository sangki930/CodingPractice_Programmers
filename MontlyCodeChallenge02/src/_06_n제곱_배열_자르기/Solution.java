package _06_n����_�迭_�ڸ���;

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
