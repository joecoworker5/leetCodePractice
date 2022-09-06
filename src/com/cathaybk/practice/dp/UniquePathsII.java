package com.cathaybk.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class UniquePathsII {

	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int result = new UniquePathsII().uniquePathsWithObstacles(obstacleGrid);
		System.out.println(result);
	}

	// dfs map memoization Time: O(m*n) , Space: O((m+n)+ m*n)
	public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		return dfs(obstacleGrid, m - 1, n - 1, m, n, map);
	}

	int dfs(int[][] obstacleGrid, int x, int y, int m, int n, Map<String, Integer> map) {

		if (x == 0 && y == 0) {
			return 1;
		}
		if (map.containsKey(x + "," + y)) {
			return map.get(x + "," + y);
		}
		int left = 0;
		int right = 0;
		if (x - 1 >= 0 && obstacleGrid[x - 1][y] == 0) {
			left = dfs(obstacleGrid, x - 1, y, m, n, map);
		}
		if (y - 1 >= 0 && obstacleGrid[x][y - 1] == 0) {
			right = dfs(obstacleGrid, x, y - 1, m, n, map);
		}

		map.put(x + "," + y, left + right);
		return left + right;
	}

	// tabulation
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
			return 0;
		}
		int[][] grid = new int[m][n];
		grid[0][0] = 1;
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if (x + 1 < m && obstacleGrid[x + 1][y] == 0) {
					grid[x + 1][y] += grid[x][y];
				}
				if (y + 1 < n && obstacleGrid[x][y + 1] == 0) {
					grid[x][y + 1] += grid[x][y];
				}
			}
		}
		return grid[m - 1][n - 1];
	}
}
