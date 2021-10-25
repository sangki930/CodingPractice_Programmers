package Week12;

import java.util.*;

class Solution {
    int[][] dungeons;
    int answer=0,length=0,k=0;
    int[] nums;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.length = dungeons.length;
        this.nums = new int[this.length];
        this.k=k;
        for(int i=0;i<length;i++)
            this.nums[i] = i;
        helper(nums,0,length);
        return answer;
    }
    
    public void helper(int nums[],int start, int length){
        if(start==nums.length){
            int tmp=k,cnt=0;
            // System.out.println(Arrays.toString(nums));
            for(int i=0;i<length;i++){
                int req = dungeons[nums[i]][0], cost = dungeons[nums[i]][1];
                // System.out.println(tmp);
                if(tmp<0) break;
                if(tmp>=req){
                    tmp-=cost;
                    cnt++;
                }else break;
            }
            answer = Math.max(answer,cnt);
            return;
        }
        
        for(int i=start;i<nums.length;i++){
            swap(nums,i,start);
            helper(nums,start+1,length);
             swap(nums,i,start);
        }
    }
     public void swap(int nums[],int first,int second){
         int temp=nums[first];
          nums[first]=nums[second];
         nums[second]=temp;
         
     }
}
