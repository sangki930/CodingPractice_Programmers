package _01_숫자문자열과영단어;

class Solution {
    public int solution(String s) {
    return Integer.parseInt(s.replace("one","1").replace("two","2").replace("three","3").replace("four","4").replace("five","5").replace("six","6").replace("seven","7").replace("eight","8").replace("nine","9").replace("zero","0"));
    }
}