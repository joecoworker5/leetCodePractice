package com.cathaybk.practice.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

	public static void main(String[] args) {

	}

	/*
	 * 0 representing an empty cell, 1 representing a fresh orange, or 2
	 * representing a rotten orange.
	 */
	public int orangesRotting(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int freshNum = 0;
		Queue<List<Integer>> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					q.add(Arrays.asList(i, j));
				}
				if (grid[i][j] == 1) {
					freshNum++;
				}
			}
		}

		if (freshNum == 0) {
			return 0;
		}
		int min = -1;
		int[][] step = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!q.isEmpty()) {
			int size = q.size();
			min++;
			while (size-- > 0) {
				List<Integer> rotten = q.poll();
				for (int i = 0; i < 4; i++) {
					int newX = rotten.get(0) + step[i][0];
					int newY = rotten.get(1) + step[i][1];
					if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
						q.add(Arrays.asList(newX, newY));
						grid[newX][newY] = 2;
						freshNum--;
					}
				}
			}
		}

		if (freshNum == 0) {
			return min;
		}

		return -1;

	}

}
