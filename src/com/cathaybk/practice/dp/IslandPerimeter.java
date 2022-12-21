package com.cathaybk.practice.dp;

public class IslandPerimeter {

	int perimeter = 0;
    //dfs
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    dfs(grid, i,j);
                }
            }
        }
        return perimeter;
    }

    void dfs(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j< 0 || j>=grid[0].length || grid[i][j]==0){
            perimeter++;
            return;
        }

        if(grid[i][j]==2){
            return;
        }

        grid[i][j]=2;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }


	// simpler solution and faster
    public int islandPerimeterSimpler(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int peri = 0, row = grid.length, col = grid[0].length;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    peri+= getPerimiter(grid, row, col, i, j);
                }
            }
        }

        return peri;
    }

    public int getPerimiter(int[][] grid, int row, int col, int ri, int ci){
        int perimiter = 0;

        if((ci-1 >= 0   && grid[ri][ci-1] == 0)  || ci-1<0)    perimiter++;
        if((ri-1 >= 0   && grid[ri-1][ci] == 0)  || ri-1<0)    perimiter++;
        if((ci+1 < col  && grid[ri][ci+1] == 0)  || ci+1>=col) perimiter++;
        if((ri+1 < row  && grid[ri+1][ci] == 0)  || ri+1>=row) perimiter++;

        return perimiter;
    }

}
