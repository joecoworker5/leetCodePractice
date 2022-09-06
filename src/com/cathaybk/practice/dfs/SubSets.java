package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = new SubSets().subsets(nums);
		System.out.println(result);

	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> finalresult = new ArrayList<>();
		finalresult.add(new ArrayList<>());
		List<Integer> result = new ArrayList<>();
		for (int size = 1; size <= nums.length; size++) {
			dfs(nums, result, finalresult, size, 0);
		}

		return finalresult;
	}

	void dfs(int[] nums, List<Integer> result, List<List<Integer>> finalresult, int size, int index) {
		if (result.size() == size) {
			finalresult.add(new ArrayList(result));
		}

		for (int i = index; i < nums.length; i++) {
			result.add(nums[i]);
			dfs(nums, result, finalresult, size, i + 1);
			result.remove(result.size() - 1);
		}
	}

}
