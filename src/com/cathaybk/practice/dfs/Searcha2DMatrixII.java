package com.cathaybk.practice.dfs;

public class Searcha2DMatrixII {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		boolean result = new Searcha2DMatrixII().searchMatrix(matrix, 5);
		System.out.println(result);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 1 && matrix[0].length == 1 && matrix[0][0] == target) {
			return true;
		} else if (matrix.length == 1 && matrix[0].length == 1 && matrix[0][0] != target) {
			return false;
		}
	

		int m = 0;
		int n = 0;
		while (m < matrix.length) {
			if (matrix[m][0] > target) {
				break;
			}
			m++;
		}
		while (n < matrix[0].length) {
			if (matrix[0][n] > target) {
				break;
			}
			n++;
		}

		return dfs(matrix, m - 1, 0, m, n, target);
	}

	boolean dfs(int[][] matrix, int x, int y, int m, int n, int target) {
		if (matrix[x][y] == target) {
			return true;
		}

		if (y + 1 < n && matrix[x][y] < target) {
			if (dfs(matrix, x, y + 1, m, n, target)) {
				return true;
			}
		} else if (x - 1 >= 0 && matrix[x][y] > target) {
			if (dfs(matrix, x - 1, y, m, n, target)) {
				return true;
			}
		}

		return false;
	}
}
