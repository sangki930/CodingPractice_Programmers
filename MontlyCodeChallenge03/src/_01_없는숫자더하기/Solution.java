package _01_���¼��ڴ��ϱ�;

public class Solution {
	public int solution(int[] numbers) {
        int answer = 0;
        int arr[]=new int[10];
        for(int i:numbers)
            arr[i]++;
        for(int i=0;i<arr.length;i++)
            if(arr[i]==1)
                answer+=i;
        return 45-answer;
    }
}
