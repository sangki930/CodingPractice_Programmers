package Week02;

class Solution {
    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        int n = scores.length;
        for(int i=0;i<n;i++){
            int arr[]=new int[101];
            int max=0,sum=0;
            int min=100;
            int max_idx=-1,min_idx=-1;
            for(int j=0;j<n;j++){
                int val = scores[j][i];
                sum+=val;
                arr[val]++;
                if(max<val){
                    max=val;
                    max_idx=j;
                }
                if(min>val){
                    min=val;
                    min_idx=j;
                }
                
            }
            
            if(max_idx==i && arr[max]==1)
                answer.append(grade((sum-max)/(n-1)));
            else if(min_idx==i && arr[min]==1)
                answer.append(grade((sum-min)/(n-1)));
            else
                answer.append(grade(sum/n));
        }
        
        return answer.toString();
    }
    
    public String grade(int score){
        score = (score/10)*10;
        String grade;
        switch(score){
            case 100,90->grade="A";
            case 80->grade="B";
            case 70->grade="C";
            case 60,50->grade="D";
            default->grade="F";
        }
        return grade;
    }
}