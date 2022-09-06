package com.cathaybk.practice.dfs;

import java.util.Arrays;

public class KthLargestElementinanArray {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int result = new KthLargestElementinanArray().findKthLargest(nums, 2);
		System.out.println(result);
	}

	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}
