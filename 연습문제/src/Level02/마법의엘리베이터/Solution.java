package Level02.마법의엘리베이터;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        String tmp = "0"+storey;
        int len = tmp.length();
        int[] arr = new int[len];

        for(int i=0;i<len;i++){
            arr[i] = tmp.charAt(i)-'0';
        }

        for(int i=len-1;i>=0;i--){
            int num = arr[i];
            if(num<5){
                answer+=num;
            }else if(arr[i]==5){
                if(arr[i-1]<5){
                    answer+=arr[i];
                }else{
                    answer+=(10-num);
                    arr[i-1]++;
                }
            }else{
                answer+=(10-num);
                arr[i-1]++;
            }
        }

        return answer;
    }
}