package com.cathaybk.practice.dp;

public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		int result = new HouseRobber().rob(nums);
		System.out.println(result);
	}

	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int[][] grid = new int[2][nums.length];
		grid[0][0] = 0;
		grid[1][0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			grid[0][i] = Math.max(grid[0][i - 1], grid[1][i - 1]);
			grid[1][i] = grid[0][i - 1] + nums[i];
		}
		return Math.max(grid[0][nums.length - 1], grid[1][nums.length - 1]);
	}
}
