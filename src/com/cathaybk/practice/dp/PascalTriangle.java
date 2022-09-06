package com.cathaybk.practice.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangle {

	public static void main(String[] args) {
		List<List<Integer>> generate = new PascalTriangle().generate(5);
		System.out.println(generate);
	}

	// dfs+memoize time: O(N), space(N^2)
	public List<List<Integer>> generate1(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		if (numRows == 0) {
			return list;
		}
		Map<Integer, Map<Integer, Integer>> memo = new HashMap<Integer, Map<Integer, Integer>>();
		for (int row = 1; row <= numRows; row++) {
			List<Integer> sub = new ArrayList<>();
			for (int i = 1; i <= row; i++) {
				if (i == 1 || i == row) {
					sub.add(1);
				} else {
					sub.add(dfs(row, i, memo));
				}
			}
			list.add(sub);
		}

		return list;
	}

	int dfs(int row, int i, Map<Integer, Map<Integer, Integer>> memo) {
		if (memo.containsKey(row) && memo.get(row).containsKey(i)) {
			return memo.get(row).get(i);
		}
		if (i == row || i == 1) {
			return 1;
		}
		int result1 = dfs(row - 1, i - 1, memo);
		int result2 = dfs(row - 1, i, memo);
		if (!memo.containsKey(row)) {
			Map<Integer, Integer> m = new HashMap<>();
			m.put(i, result1 + result2);
			memo.put(row, m);
		} else {
			Map<Integer, Integer> map = memo.get(row);
			map.put(i, result1 + result2);
		}
		return result1 + result2;
	}

	// tabulation space O(N^2) time:O(N*N)
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		if (numRows == 0) {
			return list;
		}
		int[][] dp = new int[numRows + 1][numRows + 1];
		dp[1][1] = 1;
		for (int row = 1; row <= numRows; row++) {
			List<Integer> sub = new ArrayList<>();
			for (int i = 1; i <= row; i++) {
				if (row < numRows && i < numRows) {
					dp[row + 1][i] += dp[row][i];
					dp[row + 1][i + 1] += dp[row][i];
				}
				sub.add(dp[row][i]);
			}
			list.add(sub);
		}
		return list;
	}
}
