package com.cathaybk.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

	public static void main(String[] args) {

	}

	// sorting
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		if (nums[0] != 0) {
			return 0;
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1] + 1) {
				return nums[i] - 1;
			}
		}
		return nums.length;
	}

	// set
	public int missingNumber1(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		for (int i = 0; i <= nums.length; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}

		return -1;
	}

	// XOR
	public int missingNumber2(int[] nums) {
		int result = nums.length;

		for (int i = 0; i < nums.length; i++) {
			result ^= i;
			result ^= nums[i];
		}

		return result;
	}

	// sum
	public int missingNumber3(int[] nums) {
		int sum = (0 + nums.length) * nums.length / 2;
		for (int i = 0; i < nums.length; i++) {
			sum -= nums[i];
		}
		return sum;
	}
}
