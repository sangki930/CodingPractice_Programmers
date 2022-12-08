package _2차원동전뒤집기;

class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int answer = Integer.MAX_VALUE;
        int r = beginning.length, c = beginning[0].length;
        for(int i=0;i<(1<<c);i++){
            for(int j=0;j<(1<<r);j++){
                boolean flag = true;
                int cnt1 = 0, cnt2 = 0;
                for(int k = 0; k<c;k++)
                    if(((1<<k)&i)!=0) cnt1++;
                for(int h = 0;h<r;h++)
                    if(((1<<h)&j)!=0) cnt2++;
                for(int k = 0; k<c;k++){
                    int v1 = (1<<k) & i;
                    for(int h = 0;h<r;h++){
                        int v2 = (1<<h) & j;
                        int f = beginning[h][k];
                        if(v1!=0 && v2!=0)
                            f=f;
                        else if((v1!=0) || (v2!=0))
                            f = f==1?0:1;
                        if(f!=target[h][k]){
                            flag = false;
                        }
                    }
                    
                }
                if(flag) answer = Math.min(answer,cnt1+cnt2);
            }
        }

        if(answer == Integer.MAX_VALUE) return -1;

        return answer;
    }
}
