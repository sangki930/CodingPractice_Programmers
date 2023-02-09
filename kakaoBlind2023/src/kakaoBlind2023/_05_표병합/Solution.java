package kakaoBlind2023._05_표병합;

import java.util.LinkedList;

class Cell{
    
    int r,c,group;
    // group>0은 개별 그룰, <0이면 병합된 셀
    String value;
    public Cell(int r, int c, int group, String value){
        this.r=r;
        this.c=c;
        this.group=group;
        this.value=value;
    }
    
}

class Solution {
    public String[] solution(String[] commands) {
        LinkedList<String> ret = new LinkedList<>();
        Cell[][] table = new Cell[50][50];
        
        for(int i = 0; i < 50 ; i ++){
            for(int j = 0; j < 50 ; j ++){
                table[i][j] = new Cell(i,j,i*50+j,"");
            }
        }
        
        for(String command : commands){
            
            String[] tmp = command.split(" ");
            int test1 = 0, test2 = 0;
            
            switch(tmp[0]){
                case "UPDATE"->{
                    
                    if(tmp.length==4){ // r,c를 선택하고 value로 변경
                        int r = Integer.parseInt(tmp[1])-1;
                        int c = Integer.parseInt(tmp[2])-1;
                        String value = tmp[3];
                        int group = table[r][c].group;
                        
                        for(int i = 0; i < 50 ; i ++){
                            for(int j = 0; j < 50 ; j ++){
                                if(group==table[i][j].group)
                                    table[i][j].value = value;
                            }
                        }
                        
                    }else if(tmp.length==3){ // value1을 value2로 변환
                        String value1 = tmp[1], value2 = tmp[2];
                        
                        for(int i = 0; i < 50 ; i ++){
                            for(int j = 0; j < 50 ; j ++){
                                if(table[i][j].value.equals(value1)){
                                    table[i][j].value = value2;
                                }
                                    
                            }
                        }
                    }
                    
                }
                case "MERGE"->{
                    int r1 = Integer.parseInt(tmp[1])-1;
                    int c1 = Integer.parseInt(tmp[2])-1;
                    int r2 = Integer.parseInt(tmp[3])-1;
                    int c2 = Integer.parseInt(tmp[4])-1;
                    int group1 = table[r1][c1].group;
                    int group2 = table[r2][c2].group;
                    // System.out.println("group1 : "+group1+", group2 : "+group2);
                    String value1 = table[r1][c1].value;
                    String value2 = table[r2][c2].value;
                    
                    String value = "";
                    int group = group1;
                    // System.out.println("value1 : "+value1+", value2 : "+value2);
                    if(value1.equals("") && !value2.equals("")){
                        value = value2;
                    }else if(!value1.equals("") && value2.equals("")){
                        value = value1;
                    }else if(!value1.equals("") && !value2.equals("")){
                        value = value1;
                    }
                        
                    
                    for(int i = 0; i < 50 ; i ++){
                        for(int j = 0; j < 50 ; j ++){
                            if(table[i][j].group==group1 || table[i][j].group==group2){
                                // System.out.println("번쩍");
                                table[i][j].group = group;
                                table[i][j].value = value;
                            }
                        }
                    }
                    // System.out.println("-==========");
                }
                case "UNMERGE"->{
                    int r = Integer.parseInt(tmp[1])-1;
                    int c = Integer.parseInt(tmp[2])-1;
                    int group = table[r][c].group;
                    String value = "";
                    
                    for(int i = 0; i < 50 ; i ++){
                        for(int j = 0; j < 50 ; j ++){
                            if(table[i][j].group==group){
                                value = table[i][j].value;
                                table[i][j] = new Cell(i,j,i*50+j,"");
                                if(i==r && j==c){
                                    table[i][j].value = value;
                                }
                            }
                        }
                    }
                }
                case "PRINT"->{
                    int r = Integer.parseInt(tmp[1])-1;
                    int c = Integer.parseInt(tmp[2])-1;
                    String value = table[r][c].value.isBlank()?"EMPTY":table[r][c].value;
                    ret.offer(value);
                }
            }
            // printTable(table);
        }
        
        return ret.toArray(String[]::new);
    }
    
    public void printTable(Cell[][] table){
        for(int i=0;i<4;i++){
            System.out.print("|| ");
            for(int j=0;j<4;j++){
                System.out.print(String.format(table[i][j].value,"%12s")+" || ");
            }
            System.out.println();
        }
        System.out.println("========================================");
    }
}