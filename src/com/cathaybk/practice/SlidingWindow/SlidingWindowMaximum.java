package com.cathaybk.practice.SlidingWindow;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	// Priority Queue solution
	// time complexity: O(NK(K為remove所需要的複雜度)+NlogK(忽略))
	// space: O(K)
	// Use indices since they are unique
	public int[] maxSlidingWindow(int[] nums, int k) {
		// assume nums is not null
		if (nums.length == 0 || k == 0) {
			return new int[0];
		}
		int n = nums.length;
		int[] result = new int[n - k + 1]; // number of windows

		// 讓值最大的index在左邊
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>((i1, i2) -> (nums[i2] - nums[i1])); // stores values

		for (int i = 0; i < n; ++i) {
			int start = i - k;
			if (start >= 0) {
				maxPQ.remove(start); // 當index超出window範圍時, remove掉此index
			}
			maxPQ.add(i);
			if (maxPQ.size() == k) {
				result[i - k + 1] = nums[maxPQ.peek()];
			}
		}
		return result;
	}

	/*
	 * key point: deque去實作priorityQueue, 且集合內容裝的是index
	 * 基本概念一樣是index超出window就remove, 左邊永遠保持最大值的index
	 * time complexity: O(2N)每個element只會被新增移除一次
	 * space : O(K)
	 */
	public int[] maxSlidingWindowDeque(int[] nums, int k) {
		Deque<Integer> dq = new LinkedList<>(); //也可以用ArrayDeque 因為是array實作所以存取更快
		int[] result = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {
			// 當index超出window範圍時, remove掉此index
			while (!dq.isEmpty() && dq.peek() < i - k + 1) {
				dq.pollFirst();
			}

			// 讓最大的永遠在最左邊
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}

			dq.add(i);

			if (i - k + 1 >= 0) {
				result[i - k + 1] = nums[dq.peek()];
			}

		}

		return result;
	}
}
