package kakaoBlind2020._01_���ڿ�����;

class Solution {
    public static int solution(String s) {
        
        int len = s.length();
        int answer = len;
        
        for(int i=1;i<=len/2;i++){//�ɰ� ���� ���ϱ�
            String unit = s.substring(0,i);//ù ����
            int cnt=0;//���� �� ī��Ʈ
            String result="";
            
            for(int j=0;j<=len;j=j+i){
            	
//                System.out.println("Ȯ�� : "+unit);
//                System.out.println("Ȯ�� : "+j);
                if(s.indexOf(unit,j)==j){
                    cnt++;
                    
                }
               else if(s.indexOf(unit,j)!=j){
                   
                   if(cnt>=2){
                       result = result+cnt+unit;
                   }else if(cnt<=1){
                        result = result+unit;
                   }
                   
                   cnt=1;
                   if(j+i>s.length()){
                       unit = s.substring(j,j+s.length()%i);
                       result = result+unit;
                       
                   }else{
                       unit = s.substring(j,j+i);
                   }
                   
                   
               }
                
            }
            answer = Math.min(answer, result.length());
//            System.out.println(result);
        }
        return answer;
    }
}
