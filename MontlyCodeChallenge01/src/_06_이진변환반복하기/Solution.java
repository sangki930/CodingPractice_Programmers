package _06_이진변환반복하기;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
          answer[0]++;
          String r = s.replace("0","");
          answer[1]+=s.length()-r.length();
          s = Integer.toBinaryString(r.length());
        }
        
        return answer;
    }
}
