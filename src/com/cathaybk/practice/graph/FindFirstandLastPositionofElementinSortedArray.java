package com.cathaybk.practice.graph;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {

	public static void main(String[] args) {
		int[] nums = { 0, 1 };
		int[] result = new FindFirstandLastPositionofElementinSortedArray().searchRange(nums, 0);
		System.out.println(result);
	}

	public int[] searchRange(int[] nums, int target) {
		int size = nums.length;
		int[] result = {-1,-1};
		if (size == 0) {
			return result;
		}
		boolean[] visited = new boolean[size];
		dfs(0, size, nums, result, target, visited);
		return result;
	}

	void dfs(int start, int end, int[] nums, int[] result, int target, boolean[] visited) {

		int index = (start + end) / 2;
		if (visited[index])
			return;
		visited[index] = true;
		if (nums[index] == target) {
			if (result[0] == -1 && result[1] == -1) {
				result[0] = index;
				result[1] = index;
			} else if (index < result[0]) {
				result[0] = index;
			} else if (index > result[1]) {
				result[1] = index;
			}
			dfs(index, end, nums, result, target, visited);
			dfs(start, index, nums, result, target, visited);
		} else if (nums[index] < target) {
			dfs(index, end, nums, result, target, visited);
		} else {
			dfs(start, index, nums, result, target, visited);
		}
	}
}
