package com.cathaybk.practice.twoPointer;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums = {0,0,0 };
		int target = 1;
		int result = new ThreeSumClosest().threeSumClosest(nums, target);
		System.out.println(result);
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int gap = Integer.MAX_VALUE;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int sum = nums[i];
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int total = sum + nums[start] + nums[end];
				if (total == target) {
					return target;
				} else if (total < target) {
					if (gap > (target - total)) {
						gap = target - total;
						result = total;
					}
					start++;
				} else {
					if (gap > (total - target)) {
						gap = total - target;
						result = total;
					}
					end--;
				}

				while (end >= 1 && end < nums.length - 1 && nums[end] == nums[end + 1]) {
					end--;
				}
				while (start < nums.length - 1 && start > i + 1 && nums[start] == nums[start - 1]) {
					start++;
				}
			}
		}

		return result;
	}
}
