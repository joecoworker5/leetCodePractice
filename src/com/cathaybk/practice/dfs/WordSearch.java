package com.cathaybk.practice.dfs;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
		boolean result = new WordSearch().exist(board, "ABCESEEEFS");
		System.out.println(result);
	}

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if (board[x][y] == word.charAt(0)) {
					if (word.length() > 1) {
						if (dfs(board, 0, x, y, word, new boolean[m][n])) {
							return true;
						}

					} else {
						return true;
					}
				}
			}
		}

		return false;
	}

	boolean dfs(char[][] board, int index, int x, int y, String word, boolean[][] visited) {
		if (index == word.length() - 1) {
			return true;
		}
		visited[x][y] = true;
		if (y + 1 < board[0].length && !visited[x][y + 1] && board[x][y + 1] == word.charAt(index + 1)) {
			if (dfs(board, index + 1, x, y + 1, word, visited))
				return true;
			visited[x][y + 1] = false;
		}
		if (x + 1 < board.length && !visited[x + 1][y] && board[x + 1][y] == word.charAt(index + 1)) {
			if (dfs(board, index + 1, x + 1, y, word, visited))
				return true;
			visited[x + 1][y] = false;
		}
		if (y - 1 >= 0 && !visited[x][y - 1] && board[x][y - 1] == word.charAt(index + 1)) {
			if (dfs(board, index + 1, x, y - 1, word, visited))
				return true;
			visited[x][y - 1] = false;
		}
		if (x - 1 >= 0 && !visited[x - 1][y] && board[x - 1][y] == word.charAt(index + 1)) {
			if (dfs(board, index + 1, x - 1, y, word, visited))
				return true;
			visited[x - 1][y] = false;
		}

		return false;
	}
}
