package com.cathaybk.practice.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	public static void main(String[] args) {
		List<Integer> result = new PascalsTriangleII().getRow(3);
		System.out.println(result);
	}

	// tabulation
	public List<Integer> getRow(int rowIndex) {
		int[][] dp = new int[rowIndex + 1][rowIndex + 1];
		dp[0][0] = 1;
		for (int row = 0; row <= rowIndex; row++) {
			List<Integer> sub = new ArrayList<>();
			for (int i = 0; i <= row; i++) {
				if (row < rowIndex && i < rowIndex) {
					dp[row + 1][i] += dp[row][i];
					dp[row + 1][i + 1] += dp[row][i];
				}
				sub.add(dp[row][i]);
			}
			if (rowIndex == row) {
				return sub;
			}
		}

		return null;
	}

}