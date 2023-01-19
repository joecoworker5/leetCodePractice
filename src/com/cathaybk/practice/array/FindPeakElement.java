package com.cathaybk.practice.array;

public class FindPeakElement {

    // time complexity: O(N)
    public int findPeakElement(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if((i-1<0 ||nums[i-1]<nums[i]) && (nums[i]> nums[i+1] || i+1> nums.length-1)){
                return i;
            }
        }

        return -1;
    }


    // 前提 nums[i] != nums[i + 1] for all valid i.
    // time complexity: O(logN)
    public int findPeakElementBetter(int[] arr) {
        int start=0,end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]<arr[mid+1]){
                start=mid+1;

            }else{
                end=mid;
            }

        }
        return start;
    }

}
