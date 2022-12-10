package hash.베스트앨범;

import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
       
        Map<String,LinkedHashMap<String,Integer>>
            map = new LinkedHashMap<>();
        LinkedHashMap<String,Integer> genresum = new LinkedHashMap<>();
            for(int i=0;i<genres.length;i++){
                genresum.put(genres[i],genresum.getOrDefault(genres[i],0)+plays[i]);
                map.put(genres[i],
                        map.getOrDefault(genres[i],new LinkedHashMap<>()));
                map.get(genres[i]).put(i+"",plays[i]);
                
            }
        genresum = sorting(genresum);
        List<Integer> result = new ArrayList<>();
        for(String genre : genresum.keySet()){
            int idx=0;
            for(String lm : sorting(map.get(genre)).keySet()){
                if(idx>=2)break;
                result.add(Integer.parseInt(lm));
                idx++;
            }
            
        }
        answer = new int[result.size()];
        int tt=0;
        for(int i : result)
            answer[tt++]=i;
        
        return answer;
    }
    
    public LinkedHashMap<String,Integer> sorting(LinkedHashMap<String,Integer> hm){
        List<Map.Entry<String,Integer>> entries = hm.entrySet().stream()
        .sorted(Map.Entry.comparingByValue((a,b)->b-a))
        .collect(Collectors.toList());
        hm=new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) 
        {
            hm.put(entry.getKey(),entry.getValue());
        }
        return hm;
    }
}
