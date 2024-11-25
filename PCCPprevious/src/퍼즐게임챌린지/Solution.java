package 퍼즐게임챌린지;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int low = 1, high = 200000, mid = 1;
        while(low<high){
            mid = (low+high)/2;
            long sum = 0;
            for(int i=0;i<diffs.length;i++){
                if(diffs[i]<=mid){
                    sum += times[i];
                }else{
                    sum += times[i] + (times[i]+times[i-1]) * (diffs[i]-mid);
                }
            }

            if(sum>limit){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        return low;
    }
}