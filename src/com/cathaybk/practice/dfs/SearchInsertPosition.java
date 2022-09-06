package com.cathaybk.practice.dfs;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		int result = new SearchInsertPosition().searchInsert(nums, 7);
		System.out.println(result);
	}

	public int searchInsert(int[] nums, int target) {
		int size = nums.length;
		return dfs(0, size, nums, target);
	}

	int dfs(int start, int end, int[] nums, int target) {
		int index = (start + end) / 2;

		if (end - start == 1) {
			if (target <= nums[start]) {
				return start;
			} else {
				return end;
			}
		}

		if (nums[index] >= target) {
			return dfs(start, index, nums, target);
		} else {
			return dfs(index, end, nums, target);
		}
	}

}
