package com.cathaybk.practice.array;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int result = new LongestIncreasingSubsequence().lengthOfLIS(nums);
		System.out.println(result);
	}

	public int lengthOfLIS(int[] nums) {
		List<Integer> sorted = new ArrayList<Integer>();
		for (Integer num : nums) {
			if (!sorted.isEmpty() && sorted.get(sorted.size() - 1) >= num) {
				swap(sorted, num);
			} else {
				sorted.add(num);
			}
		}

		return sorted.size();
	}

	void swap(List<Integer> sorted, Integer num) {
		int end = sorted.size() - 1;
		int start = 0;

		while (start < end) {
			int mid = (start + end) / 2;
			if (sorted.get(mid) >= num) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		sorted.set(start, num);
	}

}
