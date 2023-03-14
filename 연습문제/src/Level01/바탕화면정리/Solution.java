package Level01.바탕화면정리;

class Solution {
    public int[] solution(String[] wallpaper) throws Exception{
        int max_x = -51, max_y = -51;
        int min_x = 51, min_y = 51;

        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[i].length();j++){
                char c = wallpaper[i].charAt(j);
                if(c=='#'){
                    max_x = Math.max(max_x,i);
                    max_y = Math.max(max_y,j);
                    min_x = Math.min(min_x,i);
                    min_y = Math.min(min_y,j);
                }
            }
        }

        return new int[]{min_x,min_y,max_x+1,max_y+1};
    }
}