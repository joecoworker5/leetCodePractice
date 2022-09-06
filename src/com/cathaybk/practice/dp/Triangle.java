package com.cathaybk.practice.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle {

	public static void main(String[] args) {
	}

	// dfs+memoization time: O(2N), space: O(N*N*(1+N)/2)
	public int minimumTotal(List<List<Integer>> triangle) {
		Map<Integer, Map<Integer, Integer>> memo = new HashMap<Integer, Map<Integer, Integer>>();
		return dfs(triangle, 0, 0, memo);
	}

	int dfs(List<List<Integer>> triangle, int rowIndex, int index, Map<Integer, Map<Integer, Integer>> memo) {
		if (memo.containsKey(rowIndex) && memo.get(rowIndex).containsKey(index)) {
			return memo.get(rowIndex).get(index);
		}

		if (rowIndex + 1 == triangle.size()) {
			return triangle.get(rowIndex).get(index);
		}

		int result = triangle.get(rowIndex).get(index)
				+ Math.min(dfs(triangle, rowIndex + 1, index, memo), dfs(triangle, rowIndex + 1, index + 1, memo));
		if (!memo.containsKey(rowIndex)) {
			Map<Integer, Integer> m = new HashMap<>();
			m.put(index, result);
			memo.put(rowIndex, m);
		} else {
			Map<Integer, Integer> map = memo.get(rowIndex);
			map.put(index, result);
		}
		return result;
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int rows = triangle.size();
		int[] rowArr = new int[rows + 1];
		
	}
}
