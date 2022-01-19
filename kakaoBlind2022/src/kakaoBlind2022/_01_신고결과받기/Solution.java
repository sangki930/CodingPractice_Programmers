package kakaoBlind2022._01_신고결과받기;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        Map<String,HashSet<String>> map = new HashMap<>(); //key : 신고당한 자, value : 신고한 사람들
        Map<String,HashSet<String>> map2 = new HashMap<>(); //key : 신고한 자, value : 신고당한 사람들
        for(String r : report){
            String[] input = r.split(" ");
            String a = input[0], b = input[1]; // a : 신고한 자, b : 신고당한 자
            HashSet<String> set = map.getOrDefault(b,new HashSet<>());
            set.add(a);
            map.put(b,set);
            HashSet<String> set2 = map2.getOrDefault(a,new HashSet<>());
            set2.add(b);
            map2.put(a,set2);
        }

        answer = new int[id_list.length];
        for(int i=0;i<id_list.length;i++){
            String id = id_list[i];
            int cnt=0;
            for(String s : map2.getOrDefault(id,new HashSet<>())){
                if(map.getOrDefault(s,new HashSet<>()).size()>=k)
                    cnt++;
            }
            answer[i]=cnt;
        }
        //
        return answer;
    }
}