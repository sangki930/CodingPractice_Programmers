package kakaoBlind2022._04_양궁대회;

import java.util.*;

class Board{
    String str; 
    int score;
    long realNum;
    public Board(String str, int score, long realNum){
        this.str=str;
        this.score=score;
        this.realNum=realNum;
    }
}

class Solution {
    static int[] info;
    static int n;
    static LinkedList<Board> list=new LinkedList<>();
    public int[] solution(int n, int[] inf) {
        int[] answer = {};
        this.info=inf;
        this.n=n;

        func(this.n,0,0,new StringBuilder("00000000000"));
        StringBuilder sb  =new StringBuilder();
        
        if(list.isEmpty()) return new int[]{-1};
        Collections.sort(list,(a,b)->{
            if(a.score==b.score)
                return Long.compare(b.realNum,a.realNum);
            return Integer.compare(b.score,a.score);
        });
        answer = new int[11];
        int idx=0;

        for(char c : list.get(0).str.toCharArray()){
            answer[idx++]=c-'0';
        }

        return answer;
    }
    
    public void func(int num, int j,int ryan,StringBuilder sb){

        if(num<0) return ;
        if(j==10){
            if(ryan<=0) return ;
            StringBuilder tmp = new StringBuilder(sb);

            if(num==10)
                tmp.setCharAt(j,':');
            else
                tmp.setCharAt(j,Character.forDigit(num,10));
            long realNum=0;
            for(int k=tmp.toString().length()-1;k>=0;k--){
                if(tmp.charAt(k)==':'){
                    realNum+=(long)Math.pow(11,k)*10L;
                }else{
                    realNum+=(long)Math.pow(11,k)*(long)(tmp.charAt(k)-'0');
                }
            }
            list.offer(new Board(tmp.toString(),ryan,realNum));
            return;
        }
        
        for(int i=0;i<=info[j]+1;i++){
            
            StringBuilder tmp = new StringBuilder(sb);
            if(i==10)
                tmp.setCharAt(j,':');
            else
                tmp.setCharAt(j,Character.forDigit(i,10));
            if(info[j]==0 && i==0){
                func(num-i,j+1,ryan,tmp);
            }
            else if(info[j]<i){
                func(num-i,j+1,ryan+(10-j),tmp);
            }
            else{
             func(num-i,j+1,ryan-(10-j),tmp);   
            }
        }
    }
}