package com.cathaybk.practice.dp;

import java.util.LinkedList;
import java.util.Queue;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		new RotateArray().rotate(nums, 3);
		System.out.println();
	}

	public void rotate(int[] nums, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		k = k % nums.length;
		for (int i = 0; i < nums.length - k; i++) {
			if (nums.length - k + i < nums.length) {
				q.add(nums[nums.length - k + i]);
			}
			nums[i + k] = nums[i];
		}
		int size = q.size();
		for (int i = 0; i < size; i++) {
			nums[i] = q.poll();
		}
	}

}
