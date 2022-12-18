package com.cathaybk.practice.dfs;

public class Searcha2DMatrixII {

    public boolean searchMatrix(int[][] matrix,
                                int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        int newY = -1;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] <= target) {
                newY = j;
            }
            else {
                break;
            }
        }

        return dfs(0, newY, matrix, target);
    }

    boolean dfs(int x,
                int y,
                int[][] matrix,
                int target) {
        if (y < 0 || x >= matrix.length) {
            return false;
        }

        if (matrix[x][y] == target) {
            return true;
        }
        else if (matrix[x][y] > target) {
            return dfs(x, y - 1, matrix, target);
        }
        return dfs(x + 1, y, matrix, target);
    }
}
