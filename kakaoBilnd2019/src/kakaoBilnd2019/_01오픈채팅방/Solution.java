package kakaoBilnd2019._01오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        List<String> ansList = new ArrayList<>();
        Map<String,String> idmap = new HashMap<String,String>();
        /*
        id와 유저 이름으로 구분하므로 map을 활용(id는 중복X)
        */
        
        for(String str:record){
            StringTokenizer tokenizer = new StringTokenizer(str);
            String cmd = tokenizer.nextToken();
        
            if(cmd.equals("Enter") || cmd.equals("Change")){
                String id = tokenizer.nextToken();
                String name = tokenizer.nextToken();
                idmap.put(id,name);
            }
        }
        
        for(String str:record){
            StringTokenizer tokenizer = new StringTokenizer(str);
            String cmd = tokenizer.nextToken();//가장 첫번째는 커맨드
            if(cmd.equals("Enter"))
            {
                String id = tokenizer.nextToken();
                ansList.add(idmap.get(id)+"님이 들어왔습니다.");
                
            }else if (cmd.equals("Leave")){
                String id = tokenizer.nextToken();
                ansList.add(idmap.get(id)+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[ansList.size()];
        ansList.toArray(answer);
        return answer;
    }
}