package com.cathaybk.practice;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible {

	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int result = new AsFarfromLandasPossible().maxDistance(grid);
		System.out.println(result);

	}

	public int maxDistance(int[][] grid) {
		int[] x = { 1, -1, 0, 0 };
		int[] y = { 0, 0, 1, -1 };
		Queue<Integer[]> queue = new LinkedList<>();
		// grab the land
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					Integer[] pos = { i, j };
					queue.add(pos);
				}
			}
		}

		int dist = -1;
		if (queue.isEmpty() || queue.size() == grid.length * grid[0].length)
			return -1;
		while (!queue.isEmpty()) {
			dist++;
			int size = queue.size();
			while (size > 0) {
				Integer[] pos = queue.poll();
				for (int i = 0; i < 4; i++) {
					int newX = pos[0] + x[i];
					int newY = pos[1] + y[i];
					if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
							&& grid[newX][newY] == 0) {
						Integer[] newPos = { newX, newY };
						queue.add(newPos);
						grid[newX][newY] = 1;
					}
				}

				--size;
			}
		}

		return dist;

	}
}
