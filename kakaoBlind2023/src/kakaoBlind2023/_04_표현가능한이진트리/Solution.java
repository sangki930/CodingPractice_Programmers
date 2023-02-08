package kakaoBlind2023._04_표현가능한이진트리;

class Solution {
    
    static boolean isValid = true;
    static int idx = 0;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            long number = numbers[i];
            if((int)(Math.log(number)/Math.log(2))==Math.log(number)/Math.log(2)){
                answer[i]=1;
                continue;
            }
            
            String bi_str = Long.toBinaryString(number);
            // bi_str 값을 2^1-1, 2^2-1, 2^3-1에 길이에 맞게 만듦
            int len = bi_str.length();
            int level = (int)Math.ceil(Math.log(len+1)/Math.log(2)); // 트리의 높이
            int node_cnt = (int)Math.pow(2,level)-1;
            
            int zero_cnt = node_cnt-bi_str.length();
            // System.out.println("bi_str-->"+bi_str);
            for(int j=0;j<zero_cnt;j++){
                bi_str = "0"+bi_str;
            }
            
            this.idx = 0;
            this.isValid = true;
            inorder(1,level,bi_str);
            if(isValid){
                answer[i] = 1;
                continue;
            }else 
                answer[i] = 0;
        }
        
        return answer;
    }
    
    public char inorder(int level,int target_level,String str){
        
        char v = str.charAt(idx);
        if(level==target_level){ // 리프노드
            idx++;
            return v;
        }
        char left = inorder(level+1,target_level,str);
        v = str.charAt(idx);
        idx++;
        char right = inorder(level+1,target_level,str);
        
        if(v=='0'){
            if(!(left=='0' && right=='0'))
                isValid = false;
        }
        return v;
    }
    
}