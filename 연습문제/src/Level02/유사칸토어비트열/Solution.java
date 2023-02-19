package Level02.유사칸토어비트열;

public class Solution {

    public int solution(int n, long l, long r) {

        return (int)count_one(r)-(int)count_one(l-1);
    }

    public long count_one(long num){
        if(num==0) return 0;
        if(num<=5){
            return Long.bitCount(Integer.parseInt("11011".substring(0,(int)num),2));
        }
        int base = (int)(Math.log(num)/Math.log(5));

        long section = num / (long)Math.pow(5,base);
        long remainder = num % (long)Math.pow(5,base);
        long ret = section * (long)(Math.pow(4,base));

        if(section>=3) ret -= (long)Math.pow(4,base);
        else if(section==2) return ret;
        return ret+count_one(remainder);
    }

}