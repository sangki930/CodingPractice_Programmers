package kakaoBilnd2019._06매칭점수;

import java.util.*;

class Solution {
    
    class Page{
        int idx;
        int basic,link;//기본점수, 외부링크수
        double score;
        
        Page(int idx, int basic, int link, double score){
            this.idx=idx;
            this.link=link;
            this.basic=basic;
            this.score=score;
        }
        
    }
    
    class Comp implements Comparator<Page>{
        public int compare(Page a,Page b){
            if(a.score == b.score){
                    return a.idx-b.idx;
                }else if(a.score<b.score){
                    return 1;
                }else{
                    return -1;
                }
        }
    }
    
    public int solution(String word, String[] pages) {
        //검색어, 각 페이지에 대한 HTML 문자열
        
        int wsize = word.length();
        Map<String,Integer> pageMap = new HashMap<>();
        //페이지와 각 페이지별 인덱스
        
        List<Page> pageList = new ArrayList<>();
        word = word.toLowerCase();//검색어를 모두 소문자로 변환
        
        for(int i=0;i<pages.length;++i){
            
            String s = pages[i] = pages[i].toLowerCase();//페이지를 모두 소문자로
            int mid = 0,posl=0,posr=0;
            while(mid<=posl){
                posl = s.indexOf("<meta",posl+1);
                posr = s.indexOf(">",posl);//<meta>의 처음과 끝
                //url이 안에 있는 지
                mid = s.lastIndexOf("https://",posr);//뒤에서 찾음
            }
            
            posr = s.indexOf("\"",mid);//""를 만날때까지
            String url = s.substring(mid,posr);
           
            
            posl = s.indexOf("<body>",posr);
            int basic = 0;//기본점수
            for(int start = posl ; ;){
                start = s.indexOf(word,start+1);
              
                if(start == -1)break;
                
                if(!Character.isLetter(s.charAt(start-1)) && !Character.isLetter(s.charAt(start+wsize)) ){
                    //알파벳인지 아닌지 검사
                    basic++;
                    start+=wsize;
                    
                }
              
            }
            
            int link=0;
            for(int start = posl;;){//posl은 <body>부터 시작함
                
                start = s.indexOf("<a href",start+1);
                if(start==-1)break;//하이퍼링크가 없으면
                link++;
                
            }
          
            pageMap.put(url,i);
            pageList.add(new Page(i,basic,link,(double)basic));
        }
        
        for(int i=0;i<pages.length;++i){
            String s = pages[i];
            for(int posl=0,posr=0;;){
                posl = s.indexOf("<a href",posr);
                if(posl==-1)
                {
                    break;
                }
                posl = s.indexOf("https://",posl);
                posr=s.indexOf("\"",posl);
                String linkurl = s.substring(posl,posr);
               
                
                Integer value = pageMap.get(linkurl);
              
               
                if(value !=null){//페이지가 없을 수도 있음
                   
                    pageList.get(value.intValue()).score +=(double)pageList.get(i).basic/pageList.get(i).link;
                }
            }
        }
        
        pageList.sort((Page a,Page b)->{
        if(a.score == b.score){
                return a.idx-b.idx;
            }else if(a.score<b.score){
                return 1;
            }else{
                return -1;
            }
    });
        /*
        url을 키로하는 해시를 쓸것임
        */
        
        return pageList.get(0).idx;
    }
}