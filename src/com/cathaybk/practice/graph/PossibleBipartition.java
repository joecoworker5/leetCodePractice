package com.cathaybk.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean possibleBipartition(int n, int[][] dislikes) {
		int m = dislikes.length;
		List<List<Integer>> g = new ArrayList<List<Integer>>();
		for (int i = 0; i <= n; i++)
			g.add(new ArrayList<Integer>());
		for (int i = 0; i < m; i++) {
			g.get(dislikes[i][0]).add(dislikes[i][1]);
			g.get(dislikes[i][1]).add(dislikes[i][0]);
		}

		int[] color = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			color[i] = 1;
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			while (!q.isEmpty()) {
				Integer cur = q.poll();
				for (Integer e : g.get(i)) {
					q.add(e);
					if (color[e] == 0) {
						color[e] = color[cur] == 1 ? 2 : 1;
					} else {
						if (color[e] == color[cur])
							return false;
					}
				}
			}
		}

		return true;

	}
}
