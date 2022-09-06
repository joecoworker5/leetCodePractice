package com.cathaybk.practice.array;

import java.util.HashMap;
import java.util.Map;

public class DistantBarcodes {

	public static void main(String[] args) {
		int[] barcodes = {1,1,1,1,2,2,3,3};
		int[] result = new DistantBarcodes().rearrangeBarcodes(barcodes);
		System.out.println(result);
		
	}

	public int[] rearrangeBarcodes(int[] barcodes) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxCount = 0;
		int major = 0;
		for (int code : barcodes) {
			int count = map.getOrDefault(code, 0) + 1;
			map.put(code, count);
			if (count > maxCount) {
				maxCount = count;
				major = code;
			}
		}
		int index = 0;
		// insert odd
		while (maxCount-- > 0) {
			barcodes[2 * index++] = major;
		}
		map.remove(major);
		for (Integer key : map.keySet()) {
			Integer val = map.get(key);
			while (2 * index < barcodes.length && val-- > 0) {
				barcodes[2 * index++] = key;
			}
			map.put(key, val);
		}
		index = 0;
		// insert even
		for (Integer key : map.keySet()) {
			Integer val = map.get(key);
			while (2 * index + 1 < barcodes.length && val-- > 0) {
				barcodes[(2 * index++ + 1)] = key;
			}
		}

		return barcodes;

	}

}
