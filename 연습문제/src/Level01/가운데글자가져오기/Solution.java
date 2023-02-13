package Level01.가운데글자가져오기;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        if(s.length()%2==1){
            return s.substring(s.length()/2,(s.length()/2)+1);
        }else{
            return s.substring(s.length()/2-1,(s.length()/2)+1);
        }
        
//         return answer;
    }
}