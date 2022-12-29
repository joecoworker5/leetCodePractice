package com.cathaybk.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class CountSubIslands {

    boolean isPass = true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid2[i][j]==1){
                    dfs(grid1, grid2, i, j);
                    if(isPass){
                        count++;
                    }
                    isPass =true;
                }
            }
        }

        return count;
    }

    void dfs(int[][] grid1, int[][] grid2, int i, int j){
        if(i<0 || i>=grid1.length || j<0 || j>=grid1[0].length || grid2[i][j]!=1){
            return;
        }
        if(grid1[i][j]!=grid2[i][j]){
            isPass = false;
        }
        grid2[i][j]=0;
        dfs(grid1, grid2, i+1, j);
        dfs(grid1, grid2, i-1, j);
        dfs(grid1, grid2, i, j+1);
        dfs(grid1, grid2, i, j-1);
    }
}
