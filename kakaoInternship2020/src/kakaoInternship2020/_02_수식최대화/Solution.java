package kakaoInternship2020._02_수식최대화;

import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        String priority[] = {
            "+-*","+*-","*-+","*+-","-+*","-*+"
        };
        for(String p : priority){
            String tmp = expression;
            for(int i=0;i<3;i++){
                StringTokenizer stk = new StringTokenizer(tmp,p.substring(i+1,3),true);
        List<String> list = new LinkedList<>();

        while(stk.hasMoreTokens()){
            String nxt = stk.nextToken();

            if(nxt.equals("*") || nxt.equals("+") || nxt.equals("-"))
            {
                list.add(nxt);
                continue;
            }
            if(nxt.contains("*") || nxt.contains("-") || nxt.contains("+")){
                list.add(cal(nxt));
                continue;
            }
            list.add(nxt);
        }
        tmp="";
        for(String s : list)
            tmp+=s;
                if(list.size()==1) {
                    answer = Math.max(answer, Math.abs(Long.parseLong(convert(tmp))));
                }
            }

        }

        return answer;
    }
    public String cal(String str){
        int a=0,b=0;
        String operand=str.contains("+")?"+":str.contains("-")?"-":"*";
        int size = str.length() - str.replace(operand, "").length();
        StringTokenizer st 
            = new StringTokenizer(str,operand,true);
        int idx=0;
        long arr[] = new long[size+1];
        while(st.hasMoreTokens()){
            String nxtToken = convert(st.nextToken());

            if(idx==0) {
                arr[idx/2]=Long.parseLong(nxtToken);
            }else if(idx%2==1) {
            }else 
                 arr[idx/2]=Long.parseLong(nxtToken);
            idx++;
        }
        long res=arr[0];
        switch(operand){
            case "*":
                for(int i=1;i<arr.length;i++)
                 res=res*arr[i];
                break;
            case "+":
                for(int i=1;i<arr.length;i++)
                res=res+arr[i];
                 break;
            case "-":
                for(int i=1;i<arr.length;i++)
                    res=res-arr[i];
                 break;
        }

        return convert(String.valueOf(res));
    }

    public String convert(String value){
        if(value.contains("-"))
            return value.replace("-","m");
        if(value.contains("m"))
        return value.replace("m","-");

        return value;
    }
}
