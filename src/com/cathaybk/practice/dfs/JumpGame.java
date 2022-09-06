package com.cathaybk.practice.dfs;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;

public class JumpGame {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 0, 4 };
		boolean result = new JumpGame().canJump(nums);
		System.out.println(result);
	}

	//dfs too slow
	public boolean canJump(int[] nums) {
		int restStep = nums.length - 1;
		int firstStep = nums[0];
		return dfs(0, firstStep, restStep, nums, new boolean[nums.length]);
	}

	boolean dfs(Integer position, int jumpStep, int restStep, int[] nums, boolean[] visited) {
		if (restStep == 0) {
			return true;
		}
		if (visited[position] || restStep < 0) {
			return false;
		}

		for (int i = 1; i <= jumpStep; i++) {
			int nextStep = nums[position + i];
			if (dfs(position + i, nextStep, restStep - i, nums, visited)) {
				return true;
			}
		}

		return false;
	}
	
	//dp O(N)
	public boolean canJump1(int[] nums) {
		int reachable = 0;
    for (int i=0; i<nums.length; ++i) {
        if (i > reachable) return false;
        reachable = Math.max(reachable, i + nums[i]);
    }
    return true;
	}
}
