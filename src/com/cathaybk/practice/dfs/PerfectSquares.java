package com.cathaybk.practice.dfs;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquares {

	public static void main(String[] args) {
		int result = new PerfectSquares().numSquares(13);
		System.out.println(result);
	}

	// dfs+memoization space:O(N *N) time: O(1/2N * N)
	public int numSquares1(int n) {
		int limit = (int) Math.round(Math.sqrt(n));
		Map<Integer, Integer> memo = new HashMap<>();
		return dfs(n, limit, memo);
	}

	int dfs(int restNum, int limit, Map<Integer, Integer> memo) {
		if (memo.containsKey(restNum)) {
			return memo.get(restNum);
		}
		if (restNum == 0) {
			return 0;
		}
		int result = Integer.MAX_VALUE;
		for (int i = 1; i <= limit; i++) {
			if (restNum - Math.pow(i, 2) >= 0) {
				result = Math.min(result, 1 + dfs((int) (restNum - Math.pow(i, 2)), limit, memo));
			}
		}
		memo.put(restNum, result);
		return result;
	}

	// tabulation
	public int numSquares(int n) {
		int limit = (int) Math.round(Math.sqrt(n));
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 0; i < dp.length; i++) {
			if (i == 0 || dp[i] != 0) {
				for (int j = 1; j <= limit; j++) {
					int move = (int) Math.pow(j, 2);
					if (i + move < dp.length) {
						dp[i + move] = dp[i + move] == 0 ? (dp[i] + 1) : Math.min(dp[i] + 1, dp[i + move]);
					}
				}
			}
		}

		return dp[dp.length - 1];
	}

}
