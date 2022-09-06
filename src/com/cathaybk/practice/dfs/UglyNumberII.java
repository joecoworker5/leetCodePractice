package com.cathaybk.practice.dfs;

import java.util.HashSet;
import java.util.Set;

public class UglyNumberII {

	public static void main(String[] args) {
		int result = new UglyNumberII().nthUglyNumber(5);
		System.out.println(result);
	}

	public int nthUglyNumber(int n) {
		Set<Integer> dp = new HashSet<>();
		dp.add(1);
		int[] ele = { 2, 3, 5 };
		int i = 1;
		int count = 0;
		while (true) {
			if (dp.contains(i)) {
				if (++count == n) {
					return i;
				}
				for (int j = 0; j < ele.length; j++) {
					dp.add(i * ele[j]);
				}
			}
			i++;
		}
	}

}
