package kakaoBlind2023._06_미로탈출명령어;

class Data{
    int x,y;
    String trace;
    public Data(int x, int y, String trace){
        this.x=x;
        this.y=y;
        this.trace=trace;
    }
}

class Solution {
    
    boolean[][][] visited;
    int n, m, x, y, r, c, k;
    // 사전순이 dlru 하 좌 우 상
    int[] dx = {1,0,0,-1}, dy = {0,-1,1,0};
    char[] dir = {'d','l','r','u'};
    boolean isCompleted = false;
    String answer="";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        this.n=n;
        this.m=m;
        // this.x=x;
        // this.y=y;
        this.r=r-1;
        this.c=c-1;
        this.k=k;
        this.visited=new boolean[n][m][k+1];
        visited[x-1][y-1][0] = true;
        dfs(x-1,y-1,0,"");
        if(this.answer.isBlank() || !this.isCompleted) return "impossible";
        return this.answer;
    }
    
    public void dfs(int x, int y, int dis, String path){
        // System.out.println(path);
        if(x==this.r && y==this.c && dis == this.k){
            this.isCompleted = true;
            this.answer = path;
            return ;
        }
        
        if(dis==this.k) return;
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isInBoard(nx,ny) && dis<this.k && !visited[nx][ny][dis+1]){
                visited[nx][ny][dis+1] = true;
                dfs(nx,ny,dis+1,path+dir[i]);
                if(this.isCompleted) return;
            }
        }
        
    }
    
    public boolean isInBoard(int x, int y){
        return (0<=x && x<this.n) && (0<=y && y<this.m);
    }
}