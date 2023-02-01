package 숫자카드나누기;

import java.util.*;

class Solution {
    
    Set<Integer> set = new TreeSet<>(
        (a,b)->b-a
    );
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int a_gdc = arrayA[0], b_gdc = arrayB[0];
        
        for(int i=1;i<arrayA.length;i++){
            a_gdc = gdc(arrayA[i],a_gdc);
            b_gdc = gdc(arrayB[i],b_gdc);
        }
        
        func(a_gdc);
        func(b_gdc);
        for(int key : set){
            if(key==1) break;
            boolean flag = false;
            for(int i=0;i<arrayA.length;i++){
                if(arrayA[i]%key==0 && arrayB[i]%key==0){
                    flag = true;
                    break;
                }
            }
            if(!flag) return key;
        }
        
        return 0;
    }
    
    void func(int n){
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i>0) continue;
            set.add(i);
            set.add(n/i);
        }
    }
    
    static int gdc(int a, int b) { //최대 공약수
		if(a<b) // 유클리드 호제법 조건
		{
			int temp = a;
			a = b;
			b = temp;
		}
		while(b!=0) { // 유클리드 호제법
			int r=a%b;
			a=b;
			b=r;
		}
		return a;
	}
}