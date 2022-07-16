package 최고의집합;

class Solution {
    public int[] solution(int n, int s) {
        if(n>s) return new int[]{-1};
        
        int a = s/n; // 몫
        int mod = s%n; //나머지
        int[] answer = new int[n];
        
        for(int i=n-1;i>=0;i--){
            answer[i] = (i>n-1-mod)?a+1:a;
        }
        
        return answer;
    }
}
