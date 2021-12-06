package 멀쩡한_사각형;

public class Solution {
	public long solution(int w,int h) {
		long answer = 1;
        
        long min=Math.min(w, h);
        long max=Math.max(w, h);
        long remain=1;
        while(remain>0) {
            remain=max%min;
            max=min;
            min=remain;
        }
      return (long)w*(long)h-max*(w/max + h/max -1);
	}
}
