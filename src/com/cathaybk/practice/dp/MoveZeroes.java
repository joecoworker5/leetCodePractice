package com.cathaybk.practice.dp;


public class MoveZeroes {

    // time O(n^2)
    public void moveZeroes(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==0){
                for(int j=i+1; j<nums.length; j++){
                    if(nums[j]!=0){
                        //swap
                        int temp = nums[j];
                        nums[j]=0;
                        nums[i]=temp;
                        break;
                    }
                }
            }
        }
    }

    // time O(N)
    public void moveZeroesBetter(int[] nums) {
        if (nums == null || nums.length == 0) return;        
    
        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }        
    
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }

}
