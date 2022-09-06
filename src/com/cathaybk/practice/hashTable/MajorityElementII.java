package com.cathaybk.practice.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

	public static void main(String[] args) {

	}

	public List<Integer> majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				Integer count = map.get(i);
				map.put(i, ++count);
			}
		}
		List<Integer> result = new ArrayList<>();
		int threshold = nums.length / 3;
		for (Integer key : map.keySet()) {
			if (map.get(key) > threshold) {
				result.add(key);
			}
		}

		return result;
	}

}
