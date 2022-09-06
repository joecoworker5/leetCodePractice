package com.cathaybk.practice.dfs;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {

	}

	Set<Integer> set = new HashSet<>();

	public boolean isHappy(int n) {
		if (n == 1) {
			return true;
		}
		int sum = 0;
		String[] arr = String.valueOf(n).split("");
		for (String s : arr) {
			sum += Math.pow(Integer.valueOf(s), 2);
		}
		if (set.contains(sum)) {
			return false;
		}
		set.add(sum);
		return isHappy(sum);
	}
}
