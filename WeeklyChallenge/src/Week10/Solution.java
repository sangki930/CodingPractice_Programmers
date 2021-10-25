package Week10;

import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        
        int xMax=Integer.MIN_VALUE, xMin=Integer.MAX_VALUE;
        int yMax=Integer.MIN_VALUE, yMin=Integer.MAX_VALUE;
        LinkedList<long[]> list = new LinkedList<>();
        for(int i=0;i<line.length;i++){
            for(int j=i+1;j<line.length;j++){
                long a =line[i][0], b=line[i][1], e=line[i][2];
                long c =line[j][0], d=line[j][1], f=line[j][2];
                
                if(a*d-b*c==0) continue;
                double xTmp = ((b*f-e*d))/(double)(a*d-b*c), yTmp=((e*c-a*f))/(double)(a*d-b*c);
                if(xTmp!=(long)xTmp || yTmp!=(long)yTmp) continue;
                long x = (long)xTmp, y=(long)yTmp;
                // System.out.println(x+", "+y);
                list.offer(new long[]{x,y});
                xMax = Math.max(xMax,(int)x);
                xMin = Math.min(xMin,(int)x);
                yMax = Math.max(yMax,(int)y);
                yMin = Math.min(yMin,(int)y);
                
            }
        }
        
        String[] answer = new String[(int)(yMax-yMin+1)];
        
        char tmp[][]=new char[(int)(yMax-yMin+1)][];
        
        for(int i=0;i<answer.length;i++){
            char ch[]=new char[(int)(xMax-xMin+1)];
            Arrays.fill(ch,'.');
            tmp[i] = ch;
        }
        
        for(long[] e : list)
            tmp[(int)(e[1]-yMin)][(int)(e[0]-xMin)]='*';
        
        for(int i=0;i<answer.length;i++)
            answer[answer.length-1-i]=new String(tmp[i]);
        
        return answer;
    }
}