package com.cathaybk.practice.dfs;

public class JumpGameII {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		int jump = new JumpGameII().jump(nums);
		System.out.println(jump);
	}

	int minimumCount = Integer.MAX_VALUE;

	public int jump(int[] nums) {
		int restStep = nums.length - 1;
		int firstStep = nums[0];
		dfs(0, firstStep, restStep, nums, new boolean[nums.length], 0);
		return minimumCount;
	}

	void dfs(Integer position, int jumpStep, int restStep, int[] nums, boolean[] visited, int count) {
		if (restStep == 0) {
			minimumCount = Math.min(minimumCount, count);
		}
		if (visited[position] || restStep < 0) {
			return;
		}
		visited[position] = true;
		for (int i = 1; i <= jumpStep; i++) {
			if (position + i < nums.length) {
				int nextStep = nums[position + i];
				dfs(position + i, nextStep, restStep - i, nums, visited, count++);
			}
		}

	}

}
