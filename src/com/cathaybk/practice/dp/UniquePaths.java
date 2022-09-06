package com.cathaybk.practice.dp;

public class UniquePaths {

	public static void main(String[] args) {
		int result = new UniquePaths().uniquePaths(3, 3);
		System.out.println(result);
	}

	public int uniquePaths(int m, int n) {
		int[][] grid = new int[m][n];
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if (x == 0 && y == 0) {
					grid[x][y] = 1;
				} else if (x == 0 && y != 0) {
					grid[x][y] = grid[x][y - 1];
				} else if (y == 0 && x != 0) {
					grid[x][y] = grid[x - 1][y];
				} else {
					grid[x][y] = grid[x - 1][y] + grid[x][y - 1];
				}
			}
		}
		return grid[m - 1][n - 1];
	}

}
