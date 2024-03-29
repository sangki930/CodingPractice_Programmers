package kakaoBilnd2019._07블록게임;

class Solution {
    int N;
    int[][] Board;
    
    boolean canFill(int row, int col){//사각형으로 채워지는 지
        for(int i=0;i<row;i++){
            if(Board[i][col]!=0){
                return false;
            }
        }
        
        return true;
    }
    
    boolean find(int row, int col, int h, int w){
        int emptyCnt = 0;
        int lastValue = -1;
        for(int r=row;r<row+h;++r){
            for(int c=col;c<col+w;++c){
                if(Board[r][c]==0){
                    
                    if(!canFill(r,c)) return false;
                  if(++emptyCnt>2) return false;  
                }
                else{
                    if(lastValue!=-1 && lastValue!=Board[r][c]) return false;
                    //lastValue와 현재 위치가 다르다면
                    lastValue = Board[r][c];
                }
            }
        }
        
        for(int r=row;r<row+h;++r){
            for(int c=col;c<col+w;++c){
                Board[r][c] = 0;
            }
        }
        
        return true;
    }
    
    public int solution(int[][] board) {
        
        Board = board;
        N=board.length;
        int answer = 0;
        int cnt;//지울 수 있는 블럭
        do{
            cnt = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                
                    if(i<=N-2 && j<=N-3 && find(i,j,2,3)){
                        ++cnt;
                    }else if(i<=N-3 && j<=N-2 &&find(i,j,3,2)){
                        ++cnt;
                    }
                    
                }
            }
            answer+=cnt;
        }while(cnt!=0);

        return answer;
    }
}