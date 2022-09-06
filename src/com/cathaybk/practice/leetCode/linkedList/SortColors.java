package com.cathaybk.practice.leetCode.linkedList;

public class SortColors {

	public static void main(String[] args) {
		int[] nums = { 0 };
		new SortColors().sortColors(nums);
		System.out.println(nums);
	}

	public void sortColors(int[] nums) {
		int[] countArr = { 0, 0, 0 };
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				countArr[0] = countArr[0] + 1;
			if (nums[i] == 1)
				countArr[1] = countArr[1] + 1;
			if (nums[i] == 2)
				countArr[2] = countArr[2] + 1;
		}
		for (int i = 0; i < nums.length; i++) {
			if (countArr[0] > 0) {
				nums[i] = 0;
				countArr[0] = countArr[0] - 1;
			} else if (countArr[1] > 0) {
				nums[i] = 1;
				countArr[1] = countArr[1] - 1;
			} else if (countArr[2] > 0) {
				nums[i] = 2;
				countArr[2] = countArr[2] - 1;
			}
		}
	}
}
