package com.cathaybk.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class MaximalSquare {

	public static void main(String[] args) {

	}

	/*
	 * tabulation time: O(m*n), space(m*n)
	 */
	public int maximalSquare1(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] newMatrix = new int[m + 1][n + 1];
		int result = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					newMatrix[i][j] = Math.min(Math.min(newMatrix[i][j - 1], newMatrix[i - 1][j - 1]),
							newMatrix[i - 1][j]) + 1;
					result = Math.max(result, newMatrix[i][j]);
				}
			}
		}

		return result * result;
	}

	/*
	 * recursion+memoization 
	 * time: O(m*n) space(m*n)
	 */
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (m == 0)
			return 0;
		int result = 0;
		Map<Integer, Map<Integer, Integer>> memo = new HashMap<Integer, Map<Integer, Integer>>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					result = Math.max(result, dfs(i, j, matrix, memo));
				}
			}
		}

		return result * result;
	}

	int dfs(int i, int j, char[][] matrix, Map<Integer, Map<Integer, Integer>> memo) {
		if (i == 0 || j == 0) {
			char c = matrix[i][j];
			return Character.getNumericValue(c);
		}
		if (memo.containsKey(i) && memo.get(i).containsKey(j)) {
			return memo.get(i).get(j);
		}
		if (matrix[i][j] == '1') {
			int result = 1 + Math.min(Math.min(dfs(i - 1, j - 1, matrix, memo), dfs(i - 1, j, matrix, memo)),
					dfs(i, j - 1, matrix, memo));
			if (memo.containsKey(i)) {
				Map<Integer, Integer> map = memo.get(i);
				map.put(j, result);
			} else {
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				map.put(j, result);
				memo.put(i, map);
			}
			return result;
		}

		return 0;
	}

}
