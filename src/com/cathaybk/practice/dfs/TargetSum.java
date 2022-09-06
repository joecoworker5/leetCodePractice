package com.cathaybk.practice.dfs;

public class TargetSum {

	public static void main(String[] args) {
		int[] nums = {1 };
		int result = new TargetSum().findTargetSumWays(nums, 1);
		System.out.println(result);
	}

	int count = 0;

	public int findTargetSumWays(int[] nums, int target) {
		dfs(nums, 0, target + nums[0]);
		dfs(nums, 0, target - nums[0]);
		return count;
	}

	void dfs(int[] nums, int index, int target) {
		if (index == nums.length - 1 && target == 0) {
			count++;
			return;
		}
		if (index + 1 < nums.length) {
			dfs(nums, index + 1, target - nums[index + 1]);
			dfs(nums, index + 1, target + nums[index + 1]);
		}
	}
}
