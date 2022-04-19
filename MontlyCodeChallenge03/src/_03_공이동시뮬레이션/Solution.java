package _03_공이동시뮬레이션;

class Solution {
    int x,y,n,m;
    long[] xRange, yRange;
    public long solution(int n, int m, int y, int x, int[][] queries) {
        long answer = -1;
        if(n==0 || m==0) return 0L;
        this.x=x;this.y=y;this.n=n;this.m=m;
        // 0 : 좌, 1: 우, 2 : 상, 3: 하
        xRange = new long[]{x,x};yRange = new long[]{y,y};
        
        for(int i=queries.length-1;i>=0;i--){
            int dir = queries[i][0];
            long dx = queries[i][1];
            boolean flag = move(dir,dx);
            // System.out.println("move");
            if(!flag) return 0L;
            // System.out.println(Arrays.toString(xRange)+", "+Arrays.toString(yRange));
        }
        return (xRange[1]-xRange[0]+1L)*(yRange[1]-yRange[0]+1L);
    }
    public boolean move(int dir,long dx){
        // System.out.println(dir);
        switch(dir){
            case 0->{
                if(xRange[0]==0)
                    xRange[1]=Math.min(xRange[1]+dx,(long)(m-1));
                else{
                    if(xRange[0]+dx>=m)
                        return false;
                    xRange = new long[]{Math.min(xRange[0]+dx,m-1),Math.min(xRange[1]+dx,m-1)};
                }
                    
            }
            case 1->{
                if(xRange[1]==m-1)
                    xRange[0]=Math.max(xRange[0]-dx,0);
                else{
                    if(xRange[1]-dx<0)
                        return false;
                    xRange = new long[]{Math.max(xRange[0]-dx,0),Math.max(xRange[1]-dx,0)};
                }
            }
            case 2->{
                if(yRange[0]==0)
                    yRange[1]=Math.min(yRange[1]+dx,(long)(n-1));
                else{
                    if(yRange[0]+dx>=n)
                        return false;
                    yRange = new long[]{Math.min(yRange[0]+dx,n-1),Math.min(yRange[1]+dx,n-1)};
                }
            }
            case 3->{
                if(yRange[1]==n-1)
                    yRange[0]=Math.max(yRange[0]-dx,0);
                else{
                    if(yRange[1]-dx<0)
                        return false;
                    yRange = new long[]{Math.max(yRange[0]-dx,0),Math.max(yRange[1]-dx,0)};
                }
            }
        }
        return true;
    }
}
