package _01_������ϱ�;

public class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0;i<absolutes.length;i++){
            int b = absolutes[i];
            boolean sign=signs[i];
            answer+=sign?b:-b;
        }
        
        return answer;
    }
}