package com.cathaybk.practice.array;


class FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;

        int[] result = { -1, -1};
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                int min = mid;
                int max = mid;
                while(min>=0 && nums[min]==target){
                    min--;
                }
                while(max<nums.length && nums[max]==target){
                    max++;
                }

                result[0]=++min;
                result[1]=--max;
                return result;
            } else if (nums[mid]> target){
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}
