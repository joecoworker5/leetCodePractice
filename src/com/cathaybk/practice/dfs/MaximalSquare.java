package com.cathaybk.practice.dfs;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                memo[i][j]=-1;
            }
        }
        int result = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='1'){
                    result = Math.max(result, dfs(i, j, matrix, memo));
                }
            }
        }

        return result * result;
    }

    public int dfs(int i, int j, char[][] matrix, int[][] memo){
        if(i==0 || j==0){
            char c = matrix[i][j];
            return Character.getNumericValue(c);
        }
        if(i<0 || j<0){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }

        if(matrix[i][j]=='1'){
            int result = 1 + Math.min(Math.min(dfs(i-1, j-1, matrix, memo),dfs(i, j-1, matrix, memo)),dfs(i-1, j, matrix, memo));
            memo[i][j]= result;
            return result;
       }

        return 0;
    }
}
