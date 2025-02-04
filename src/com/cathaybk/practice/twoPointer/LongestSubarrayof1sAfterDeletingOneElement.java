package com.cathaybk.practice.twoPointer;

public class LongestSubarrayof1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int i=0;
        int j=0;
        int k=1;
        int longest = 0;
        while(i<nums.length){
            if(nums[i++]==0) k--;
            while(k<0){
                if(nums[j++]==0) k++;
            }
            longest = Math.max(longest, i-j-1);
        }
        return longest;
    }
}
