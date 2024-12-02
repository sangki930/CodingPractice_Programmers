package 수식복원하기;

import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        String[] answer = {};
        Set<Integer> set = new HashSet<>();

        for(int i=2;i<=9;i++){
            boolean flag = true;
            for(String expression : expressions){
                String[] input = expression.split(" ");

                int result = 0;
                try{
                    switch(input[1]){
                        case "+"->{
                            result = Integer.parseInt(input[0],i) + Integer.parseInt(input[2],i);
                            if("X".equals(input[4])) continue;
                            if(Integer.parseInt(input[4],i) != result){
                                flag = false;
                            }
                        }
                        case "-"->{
                            result = Integer.parseInt(input[0],i) - Integer.parseInt(input[2],i);
                            if("X".equals(input[4])) continue;
                            if(Integer.parseInt(input[4],i) != result){
                                flag = false;
                            }
                        }
                    }
                }catch(Exception e){
                    flag = false;

                }
            }
            if(flag) set.add(i);
        }

        LinkedList<String> ret = new LinkedList<>();
        for(String expression : expressions){
            if(!expression.contains("X")) continue;
            String[] input = expression.split(" ");
            int result = 0;
            Set<String> tmp = new HashSet<>();
            for(int i : set){
                switch(input[1]){
                    case "+"->{
                        tmp.add(Integer.toString(Integer.parseInt(input[0],i) + Integer.parseInt(input[2],i) ,i));
                    }
                    case "-"->{
                        tmp.add(Integer.toString(Integer.parseInt(input[0],i) - Integer.parseInt(input[2],i) ,i));
                    }
                }
            }
            if(tmp.size()==1){
                ret.offer(expression.substring(0,expression.indexOf("=")+2) + tmp.iterator().next());
            }else{
                ret.offer(expression.substring(0,expression.indexOf("=")+2) + "?");
            }
        }

        return ret.toArray(String[]::new);
    }
}