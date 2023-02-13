package Level01._2016년;

import java.time.*;
class Solution {
    public String solution(int a, int b) {
        String answer = "";     
        LocalDate ld = LocalDate.of(2016,a,b);
        return ld.getDayOfWeek().toString().substring(0,3);
    }
}
