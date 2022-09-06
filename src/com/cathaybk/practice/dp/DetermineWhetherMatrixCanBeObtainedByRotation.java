package com.cathaybk.practice.dp;

public class DetermineWhetherMatrixCanBeObtainedByRotation {

	public static void main(String[] args) {
		int[][] mat = { { 0, 1 }, { 1, 1 } };
		int[][] target = { { 1, 0 }, { 0, 1 } };
		boolean result = new DetermineWhetherMatrixCanBeObtainedByRotation().findRotation(mat, target);
		System.out.println(result);
	}

	public boolean findRotation(int[][] mat, int[][] target) {
		int count = 3;
		while (count-- >= 0) {
			rotate(mat);
			if (checkIfEqual(mat, target)) {
				return true;
			}
		}

		return false;
	}

	public void rotate(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[m - i - 1][j];
				matrix[m - i - 1][j] = temp;
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j > i) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}
	}

	boolean checkIfEqual(int[][] mat, int[][] target) {
		int m = mat.length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] != target[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
}
