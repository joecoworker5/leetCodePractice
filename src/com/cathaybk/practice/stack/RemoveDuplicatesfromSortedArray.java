package com.cathaybk.practice.stack;

import java.util.Stack;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {

		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int result = new RemoveDuplicatesfromSortedArray().removeDuplicates(nums);
		System.out.println(result);
	}

	public int removeDuplicates1(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			if (s.isEmpty()) {
				s.add(nums[i]);
			} else if (s.peek() != nums[i]) {
				s.add(nums[i]);
			}
		}
		int count = s.size();
		while (!s.isEmpty()) {
			nums[s.size() - 1] = s.pop();
		}
		return count;
	}

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int previousIndex = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				continue;
			nums[++previousIndex] = nums[i];
		}
		return previousIndex + 1;
	}
}
