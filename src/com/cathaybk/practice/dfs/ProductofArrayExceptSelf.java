package com.cathaybk.practice.dfs;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {

	}

	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		int left = 1;
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			left = left * nums[i - 1];
			res[i] = left;
		}

		int right = 1;
		for (int i = n - 2; i >= 0; i--) {
			right = right * nums[i + 1];
			res[i] = res[i] * right;
		}

		return res;
	}
}
