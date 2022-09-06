package com.cathaybk.practice.dfs;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {

	public static void main(String[] args) {

	}

	public int integerBreak(int n) {
		int max = 0;
		Map<Integer, Integer> memo = new HashMap<>();
		for (int i = 1; i < n; i++) {
			max = Math.max(max, i * dfs(n-i, memo));
		}
		return max;
	}

	int dfs(int n, Map<Integer, Integer> memo) {
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		if (n == 0) {
			return 1;
		}
		int max = 0;

		for (int i = 1; i <= n; i++) {
			max = Math.max(max, i * dfs(n - i, memo));
		}

		memo.put(n, max);
		return max;
	}

}
