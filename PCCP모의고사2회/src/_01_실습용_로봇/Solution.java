package _01_角嚼侩_肺嚎;

class Solution {
    public int[] solution(String command) {
        int[] answer = {0,0};
        int dir = 0;
        
        for(char c : command.toCharArray()){
            
            switch(c){
                case 'R'->{
                    dir = (++dir)%4;
                }
                case 'L'->{
                    dir = dir==0?3:--dir;
                }
                case 'G'->{
                    go(dir,answer);
                }
                case 'B'->{
                    back(dir,answer);
                }
            }
        }
        return answer;
    }
    
    public int[] go(int dir, int[] point){
        switch(dir){
            case 0->{ // 合率
                point[1]++;
            }
            case 1->{ // 悼率
                point[0]++;
            }
            case 2->{ // 巢率
                point[1]--;
            }
            case 3->{ // 辑率
                point[0]--;
            }
        }
        return point;
    }
    
    public int[] back(int dir, int[] point){
        switch(dir){
            case 0->{ // 合率
                point[1]--;
            }
            case 1->{ // 悼率
                point[0]--;
            }
            case 2->{ // 巢率
                point[1]++;
            }
            case 3->{ // 辑率
                point[0]++;
            }
        }
        return point;
    }
}