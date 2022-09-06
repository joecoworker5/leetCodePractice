package com.cathaybk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PathwithMaximumGold {

	public static void main(String[] args) {
		int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
		int result = new PathwithMaximumGold().getMaximumGold(grid);
		System.out.println();
		String s = "1 2 4";
		Integer[] split = {1,2,3,4};
		List<List<Integer>> asList = new ArrayList<List<Integer>>();
		System.out.println(asList);
		asList.sort(new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.get(0)-o2.get(0);
			}
		});
		Integer x = 1;
		x.to
	}

	public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]!=0){
                     max = Math.max(max, dfs(grid, i, j, visited, 0));
                }
            }
        }
        
        return max;
    }
    
    int dfs(int[][] grid, int i, int j, boolean[][] visited, int sum){
        sum+=grid[i][j];
        visited[i][j]=true;
        int result = 0;
        if(i+1<grid.length && !visited[i+1][j] && grid[i+1][j]!=0){
            result = Math.max(dfs(grid, i+1, j, visited, sum), result);
        }
        if(i-1>=0 && !visited[i-1][j] && grid[i-1][j]!=0){
            result = Math.max(dfs(grid, i-1, j, visited, sum), result);
        }
        if(j+1<grid[0].length && !visited[i][j+1] && grid[i][j+1]!=0){
            result = Math.max(dfs(grid, i, j+1, visited, sum), result);
        }
        if(j-1>=0 && !visited[i][j-1] && grid[i][j-1]!=0){
            result = Math.max(dfs(grid, i, j-1, visited, sum), result);
        }
        visited[i][j]=false;
        return result + sum;
        
    }
}
