package Level01.대충만든자판;

import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character,int[]> map = new HashMap<>();

        for(int i=0;i<keymap.length;i++){
            char[] ch = keymap[i].toCharArray();
            for(int j=0;j<ch.length;j++){
                char c = ch[j];
                int[] a = map.getOrDefault(c,new int[]{i,Integer.MAX_VALUE});
                if(a[1]>j){
                    a = new int[]{i,j};
                }
                map.put(c,a);
            }
        }

        for(int i=0;i<targets.length;i++){
            char[] ch = targets[i].toCharArray();
            int cnt = 0;
            for(int j=0;j<ch.length;j++){
                char c = ch[j];
                int[] a = map.getOrDefault(c,new int[]{i,Integer.MAX_VALUE});
                if(a[1]==Integer.MAX_VALUE){
                    answer[i] = -1;
                    break;
                }
                cnt+=a[1]+1;
            }
            if(answer[i]>=0){
                answer[i] = cnt;
            }
        }
        return answer;
    }
}
