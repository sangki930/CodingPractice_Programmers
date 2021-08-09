package Week01;

public class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        for(int i=1;i<=count;i++)
            answer+=i*price;
        return Math.max(answer-money,0L);
    }
}
