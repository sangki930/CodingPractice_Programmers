package _05_쿼드압축후개수세기;

class Solution {
    
    public static int zero;
    public static int one;
    public int[] solution(int[][] arr) {
        int[] answer = {};
        zero=0;
        one =0;
        int arrLen = arr.length;
        
        recursive(arr,0,0,arrLen);
        
        return new int[]{zero,one};
    }
    
    public void recursive(int[][] arr, int a, int b, int len){
        if(len == 1) {                                                        //종료 조건
            if(arr[a][b] == 0) 
                zero++;
            else 
                one++;
            return;
        }
        
        int value = arr[a][b];
        boolean flag = true;
        for (int i = a; i < a + len; i++) {
            if (flag) {
                for (int j = b; j < b + len; j++) {
                    if (value != arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
            } else {
                break;
            }
        }
 
        if (flag) {                     // 같은 수 일 때
            if (value == 1) {
                one++;
            } else {
                zero++;
            }
        } else {
            len = len/2;
            
            recursive(arr, a, b, len);
            recursive(arr, a + len, b, len);
            recursive(arr, a, b + len, len);
            recursive(arr, a + len, b + len, len);
        }
    }
}
