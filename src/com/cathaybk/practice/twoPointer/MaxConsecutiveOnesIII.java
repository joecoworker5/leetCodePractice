package com.cathaybk.practice.twoPointer;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int i=0, j=0;
        int longest = 0;
        while(i<nums.length){
            if(nums[i++]==0) k--;
            while(k<0){
                if(nums[j++]==0){
                    k++;
                }
            }
            longest = Math.max(longest, i-j);
        }

        return longest;
    }
}
