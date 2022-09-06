package com.cathaybk.practice.graph;

public class IslandPerimeter {

	public static void main(String[] args) {
		int[][] array = new int[1][2];
		array = {[0],[1]};

		int result = new IslandPerimeter().islandPerimeter(array);
		System.out.println(result);
	}

	int totalPerimeter = 0;

	public int islandPerimeter(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for (int x = 0; x < m; ++x) {
			for (int y = 0; y < n; ++y) {
				if (grid[x][y] == 1) {
					dfs(x, y, m, n, new boolean[m][n], grid);
					break;
				}
			}
			break;
		}

		return totalPerimeter;
	}

	void dfs(int x, int y, int m, int n, boolean[][] visited, int[][] grid) {

		if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || grid[x][y] != 1) {
			totalPerimeter++;
			return;
		}

		if (visited[x][y]) {
			return;
		}
		visited[x][y] = true;
		dfs(x + 1, y, m, n, visited, grid);
		dfs(x - 1, y, m, n, visited, grid);
		dfs(x, y + 1, m, n, visited, grid);
		dfs(x, y - 1, m, n, visited, grid);
	}
}
