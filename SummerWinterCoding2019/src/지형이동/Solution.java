package 지형이동;

import java.util.*;

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    @Override
    public String toString(){
        return "{ x : "+this.x+", y : "+this.y+" }";
    }
}

class Edge {
    int u, v, w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
    @Override
    public String toString(){
        return "{ u : "+this.u+", v : "+this.v+", w : "+this.w+" }";
    }
}

class Node{
    int e;
    int v;
    public Node(int e, int v){
        this.e=e;
        this.v=v;
    }
    @Override
    public String toString(){
        return "{ e : "+this.e+", v : "+this.v+" }";
    }
}

class Solution {
    
    int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    int[] uf;
    public int find(int a){
        if(uf[a]<0) return a;
        return uf[a] = find(uf[a]);
    }
    
    public boolean merge(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return false;
        uf[b]=a;
        return true;
    }
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        int n = land.length;
        int[][] visited = new int[n][n];
        int level=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[j][i]>0) continue;
                LinkedList<Point> queue = new LinkedList<>();
                queue.offer(new Point(i,j));
                
                while(!queue.isEmpty()){
                    Point p = queue.poll();
                    if(visited[p.y][p.x]==level) continue;
                    visited[p.y][p.x]=level;
                    for(int k=0;k<4;k++){
                        int nx = p.x+dx[k], ny = p.y+dy[k];
                        if(nx>=0 && ny>=0 && nx<n && ny<n && Math.abs(land[ny][nx]-land[p.y][p.x])<=height ){
                            // visited[ny][nx]=level;
                            queue.offer(new Point(nx,ny));
                        }
                    }
                }
                level++;
            }
        }
        
        ArrayList<Edge> e = new ArrayList<>();
        
        for(int x=0; x<n; x++){
            for(int y=0;y<n;y++){
                for (int i = 0; i < 4; i++) {
                    int nx = x+dx[i];
                    int ny = y+dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (visited[y][x] == visited[ny][nx]) continue;

                    int comp1 = visited[y][x];
                    int comp2 = visited[ny][nx];

                    int p = Math.abs(land[y][x] - land[ny][nx]);
                    e.add(new Edge(comp1, comp2, p));
                }
            }
        }
        
        if(e.isEmpty()) return 0;
        
        uf = new int[level];
        Arrays.fill(uf,-1);
        e.sort((a,b)->Integer.compare(a.w,b.w));
        int cnt=0;
        // System.out.println(e);
        for (int i=0;i<e.size();i++) {
            if (merge(e.get(i).u, e.get(i).v)) {
                answer += e.get(i).w;
                if (++cnt == level) break;
            }
        }
        
        return answer;
    }
}