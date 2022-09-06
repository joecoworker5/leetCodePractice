package com.cathaybk.practice;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {

	}

	public boolean isValidSudoku(char[][] board) {
		Set<Character> set = new HashSet<>();
		// row check
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != '.') {
					if (!set.contains(board[i][j])) {
						set.add(board[i][j]);
					} else {
						return false;
					}
				}
			}
			set.clear();

			for (int j = 0; j < board.length; j++) {
				if (board[j][i] != '.') {
					if (!set.contains(board[j][i])) {
						set.add(board[j][i]);
					} else {
						return false;
					}
				}
			}
			set.clear();
			
			for (int j = 0; j < board.length; j++) {
				if ((i == 0 || i == 3 || i == 6) && (j == 0 || j == 3 || j == 6)) {
					for (int z = 0; z < 3; z++) {
						for (int y = 0; y < 3; y++) {
							if (board[i + z][j + y] != '.') {
								if (!set.contains(board[i + z][j + y])) {
									set.add(board[i + z][j + y]);
								} else {
									return false;
								}
							}
						}
					}
				}

				set.clear();
			}
		}

		return true;

	}

}
