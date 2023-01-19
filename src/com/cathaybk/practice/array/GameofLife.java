package com.cathaybk.practice.array;

public class GameofLife {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1){
                    flip(i, j, board,  true);
                } else {
                    flip(i, j, board, false);
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]== 2){
                    board[i][j]=0;
                } else if( board[i][j]==-1){
                    board[i][j]=1;
                }
            }
        }
    }


    void flip(int i, int j, int[][] board, boolean isOne){
        int[][] steps = {{1,1},{-1,-1},{1,-1},{-1, 1},{1,0},{-1,0},{0,1}, {0,-1}};
        int count = 0;
        for(int[] step: steps){
            int newI = i+step[0];
            int newJ = j+ step[1];
            if(newI>=0 && newI < board.length && newJ>=0 && newJ < board[0].length && (board[newI][newJ]==1 || board[newI][newJ]==2)){
                count++;
            }
        }
        if(isOne) {
            if (count != 2 && count != 3) {
                board[i][j] = 2;
            }
        } else {
            if(count==3){
                board[i][j] = -1;
            }
        }
    }

}
