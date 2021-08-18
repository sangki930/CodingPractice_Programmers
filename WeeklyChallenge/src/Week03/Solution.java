package Week03;

import java.util.*;

class Pair{
    int x;
    int y;
    
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    @Override
    public String toString(){
        return "[ x : "+this.x+", y : "+this.y+" ]";
    }
}

class Block{
    int x_max;
    int x_min;
    int y_max;
    int y_min;
    LinkedList<int[]> list;
    public Block(){
        this.x_max = Integer.MIN_VALUE;
        this.x_min = Integer.MAX_VALUE;
        this.y_max = Integer.MIN_VALUE;
        this.y_min = Integer.MAX_VALUE;
        this.list = new LinkedList<>();
    }
    public Block(
        int x_max,
        int x_min,
        int y_max,
        int y_min,
        LinkedList<int[]> list
    ){
        this.x_max = x_max;
        this.x_min = x_min;
        this.y_max = y_max;
        this.y_min = y_min;
        this.list = list;
    }
}

class Solution {
    int dx[]={0,-1,0,1};
    int dy[]={1,0,-1,0};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        LinkedList<Block> bl = func(game_board,0);
        LinkedList<Block> bl2 = func(table,1);
        Comparator<int[]> comp = new Comparator<>() {
              @Override
              public int compare(int a[], int b[]) { 
                if(a[0]==b[0])
                    return Integer.compare(a[1],b[1]);
                  return Integer.compare(a[0],b[0]);
              }
        };

        for(Block block : bl){
            int z = bl2.size();
            block.list.sort(comp);
            
            outerloop:for(int i=0;i<z;i++){
                Block tmp = bl2.poll();
                boolean find=false;
                loop : for(int j=0;j<4;j++){
                    tmp = rotate(tmp);
                    tmp.list.sort(comp);
                    boolean flag=true;
                    if(tmp.list.size()!=block.list.size()){
                        break loop;
                    }else{
                        
                        for(int k=0;k<tmp.list.size();k++){
                            if(tmp.list.get(k)[0]!=block.list.get(k)[0] || tmp.list.get(k)[1]!=block.list.get(k)[1]){
                                flag=false;
                                break;
                            }
                        }
                        if(flag){
                            System.out.println(tmp.list.size());
                            answer+=tmp.list.size();
                            find = true;
                            break outerloop;
                        }
                    }
                }
                if(!find)
                    bl2.offer(tmp);
            }
            
        }
        
        return answer;
    }
    
    public LinkedList<Block> func(int[][] arr, int val){
        int bRow=arr.length;
        int bCol=arr[0].length;
        boolean visited[][]=new boolean[bRow][bCol];
        LinkedList<Block> blocklist = new LinkedList<>();
        int c,d;
        if(val==1)
        {
            c=0;d=1;
        }else{
            c=1;d=0;
        }
        for(int i=0;i<bRow;i++){
            for(int j=0;j<bCol;j++){
                
                if(arr[i][j]==c)
                    continue;
                
                LinkedList<Pair> queue = new LinkedList<>();
                queue.offer(new Pair(j,i));
                Block block = new Block();
                int cnt=0;
                while(!queue.isEmpty()){
                    Pair p = queue.poll();
                    
                    if(visited[p.y][p.x])
                        continue;
                    if(!visited[p.y][p.x]){
                        cnt++;
                        block.x_max = Math.max(block.x_max,p.x);
                        block.y_max = Math.max(block.y_max,p.y);
                        block.x_min = Math.min(block.x_min,p.x);
                        block.y_min = Math.min(block.y_min,p.y);
                        block.list.offer(new int[]{p.x,p.y});
                    }
                        
                    visited[p.y][p.x]=true;
                    
                    for(int k=0;k<4;k++){
                        int nx=p.x+dx[k];
                        int ny=p.y+dy[k];
                        if(nx>=0 && nx<bCol && ny>=0 && ny<bRow && arr[ny][nx]==d){
                            
                            queue.offer(new Pair(nx,ny));
                        }
                    }
                    
                }
                
                int size = block.list.size();
                for(int l=0;l<size;l++){
                    int tt[]=block.list.poll();
                    
                    tt[0]-=block.x_min;
                    tt[1]-=block.y_min;
                    block.list.offer(tt);
                }
                if(cnt>0)
                    blocklist.offer(block);
            }
        }
              
        return blocklist;
    }
    
    public boolean[][] test(boolean[][] a){
        
        int r = a.length;
        int c = a[0].length;
        boolean[][] b = new boolean[c][r];
        
		for(int row=0;row<c;row++){
			for(int col=0;col<r;col++){
				b[row][col]=a[col][c-1-row];
			}
		}
        
        return b;
    }
    
    public Block rotate(Block tmp){
		LinkedList<int[]> tmplist = new LinkedList<>();
        
        int x_max = Integer.MIN_VALUE;
        int x_min = Integer.MAX_VALUE;
        int y_max = Integer.MIN_VALUE;
        int y_min = Integer.MAX_VALUE;
        
        if(tmp.list.isEmpty())
            return tmp;
        
        for(int tt[]:tmp.list){
            x_max = Math.max(x_max,tt[0]);
            x_min = Math.min(x_min,tt[0]);
            y_max = Math.max(y_max,tt[1]);
            y_min = Math.min(y_min,tt[1]);
        }
        int r = y_max;
        int c = x_max;
        
        boolean vv[][]=new boolean[r+1][c+1];
        for(int tt[]:tmp.list){
            vv[tt[1]][tt[0]]=true;
        }
        vv=test(vv);
        for(int i=0;i<vv.length;i++)
            for(int j=0;j<vv[0].length;j++)
                if(vv[i][j])
                    tmplist.offer(new int[]{j,i});
        
        tmp.list = tmplist;
        return tmp;
    }
    
}
