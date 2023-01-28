package kakaoBilnd2019._03후보키;

import java.util.*;

class Solution {
    
    boolean check(String[][] relation, int rowsize, int colsize,int subset){
        for(int a = 0;a<rowsize-1;++a){
            for(int b = a+1;b<rowsize;++b){
                boolean isSame =true;
                for(int k=0;k<colsize;++k){
                    if((subset & 1<<k)==0)continue;
                    if(!relation[a][k].equals(relation[b][k])){
                        isSame  = false;
                        break;
                    }
                }
                if(isSame) return false;//모든 속성이 같다는 것
            }
        }
        
        return true;
    };

    
    public int solution(String[][] relation) {
        
        /*비트 연산으로 매핑*/
        int answer = 0;
        int rowsize = relation.length;//튜플 개수
        int colsize = relation[0].length;//컬럼 개수
        
        List<Integer> candidates = new LinkedList<>();

        for(int i=1;i<1<<colsize;++i){
            
            if(check(relation,rowsize,colsize,i)){
                //후보키를 모두 만족하면
                candidates.add(i);
            }
            
        }//공집합 제외하고 모든 부분집합 구현
        
        while(candidates.size()!=0){
            int n = candidates.remove(0);
            ++answer;
            
            for(Iterator<Integer> it = candidates.iterator();it.hasNext();){
                int c = it.next();//n이 갖고 있는 모든 속성을 들고있다.
                if((n&c)==n)
                    it.remove();
            }
            
           
        }
        
        return answer;
    }
}
