package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.List;

public class WhereWilltheBallFall {

    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];
        for(int j=0; j<n; j++){
            result[j] = getResult(0, j, grid);
        }

        return result;
    }

    int getResult(int i, int j, int[][] grid){
        if(i>=grid.length){
            return j;
        }
        if(grid[i][j]==1){
            if( j+1>=grid[0].length || grid[i][j+1] == -1){
                return -1;
            } else {
                return getResult(i+1, j+1, grid);
            }
        } else {
            if( j-1<0 || grid[i][j-1]==1){
                return -1;
            } else {
                return getResult(i+1, j-1, grid);
            }
        }
    }
}
