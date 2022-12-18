package com.cathaybk.practice.array;


class SearchinRotatedSortedArray {

	public int search(int[] nums, int target) {
		int minIndex = findMinIndex(nums);
		 if (nums[minIndex] == target)
			 return minIndex;
 
		 int m = nums.length;
		 int start = (target <= nums[m - 1]) ? minIndex : 0;
		 int end = (target > nums[m - 1]) ? minIndex : m - 1;
		 while (start <= end) {
			 int mid = (start + end) / 2;
			 if (target == nums[mid]) {
				 return mid;
			 } else if (target > nums[mid]) {
				 start = mid + 1;
			 } else {
				 end = mid - 1;
			 }
		 }
 
		 return -1;
 
	 }
 
	 int findMinIndex(int[] nums) {
		 int start = 0;
		 int end = nums.length - 1;
		 while (start < end) {
			 int mid = (end + start) / 2;
			 if (nums[mid] > nums[end])
				 start = mid + 1;
			 else {
				 end = mid;
			 }
		 }
		 return start;
	 }

}
