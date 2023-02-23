package Level03.선입선출스케줄링;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;

        int min = 0; 
        int max = 100000000;

        int time = 0;
        int m = 0; 

        while (min <= max) {  
            int mid = (min+max)/2;

            int cnt = cntWork(mid, cores);

            if (cnt >= n) { 
                max = mid-1;   
                time = mid;     
                m = cnt; 
            }else{
                min = mid+1;
            }
        }

        m-=n; 
        for(int i = cores.length-1; i>=0; i--){
            if (time % cores[i] == 0) { 
                if (m == 0) {
                    answer = i+1;
                    break;
                }
                m--;
            }
        }

        return answer;
    }

    public int cntWork(int time, int[] cores){
        int cnt = cores.length; 
        for(int i = 0; i<cores.length; i++){ 
            cnt += (time/cores[i]);
        }
        return cnt;
    }

}