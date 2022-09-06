package com.cathaybk.practice.dfs;

public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 } };
		int result = new MinimumPathSum().minPathSum(grid);
		System.out.println(result);
	}

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		return dfs(grid, 0, 0, m, n, 0);
	}

	int dfs(int[][] grid, int x, int y, int m, int n, int total) {
		if (x == m - 1 && y == n - 1) {
			total = total + grid[x][y];
			return total;
		}
		total = total + grid[x][y];
		if (x + 1 <= m - 1 && y == n - 1) {
			return dfs(grid, x + 1, y, m, n, total);
		} else if (y + 1 <= n - 1 && x == m - 1) {
			return dfs(grid, x, y + 1, m, n, total);
		}

		return Math.min(dfs(grid, x + 1, y, m, n, total), dfs(grid, x, y + 1, m, n, total));
	}
}
