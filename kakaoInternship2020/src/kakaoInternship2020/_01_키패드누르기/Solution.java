package kakaoInternship2020._01_키패드누르기;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        String p_hand="";
        int L=10,R=12;
        for(int num : numbers){
           
            if(num==0)
                num=11;
            switch(num){
                case 1,4,7->{
                    L=num;
                    sb.append("L");
                }
                case 3,6,9->{
                    R=num;
                    sb.append("R");
                }
                case 2,5,8,11->{
                    int L_dis=0, R_dis=0;
                    
                    if(L%3==2){
                        L_dis = (int)Math.abs(L-num)/3;
                    }else if(L%3==1){
                        L_dis = (int)Math.abs((L+1)-num)/3+1;
                    }
                    if(R%3==2){
                        R_dis = (int)Math.abs(R-num)/3;
                    }else if(R%3==0){
                        R_dis = (int)Math.abs((R-1)-num)/3+1;
                    }
                    
                    if(L_dis > R_dis){
                        R=num;
                        sb.append("R");
                    }else if(L_dis < R_dis){
                        L=num;
                        sb.append("L");
                    }else if(L_dis==R_dis){
                        if(hand.equals("right")){
                            R=num;
                            sb.append("R");
                        }else if(hand.equals("left")){
                            L=num;
                            sb.append("L");
                        }
                            
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
