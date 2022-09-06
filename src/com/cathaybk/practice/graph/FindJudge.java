package com.cathaybk.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class FindJudge {

	public static void main(String[] args) {
		int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		int result = new FindJudge().findJudge(4, trust);
		System.out.println(result);
	}

	public int findJudge(int n, int[][] trust) {
		if (n == 1 && trust.length == 0) {
			return 1;
		}
		List<Integer>[] lists = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			lists[i] = new ArrayList<>();

		int judge = -1;
		for (int i = 0; i < trust.length; i++) {
			lists[trust[i][1]].add(trust[i][0]);
			if (lists[trust[i][1]].size() == n - 1) {
				judge = trust[i][1];
			}
		}
		if (judge < 0) {
			return judge;
		}
		for (int i = 1; i <= n; i++) {
			if (i == judge)
				continue;
			if (lists[i].contains(judge)) {
				return -1;
			}
		}

		return judge;

	}
	   //
	   public int findJudge1(int N, int[][] trust) {
	        int[] count = new int[N+1];
	        for (int[] t: trust) {
	            count[t[0]]--;
	            count[t[1]]++;
	        }
	        for (int i = 1; i <= N; ++i) {
	            if (count[i] == N - 1) return i;
	        }
	        return -1;
	    }

}
