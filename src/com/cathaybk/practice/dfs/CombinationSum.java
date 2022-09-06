package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> finalResult = new ArrayList<List<Integer>>();
		List<Integer> result = new ArrayList<Integer>();
		findResult(candidates, 0, target, result, finalResult);
		return finalResult;
	}

	void findResult(int[] candidates, int cur, int newTarget, List<Integer> result, List<List<Integer>> finalResult) {
		if (newTarget == 0) {
			finalResult.add(new ArrayList(result));
		}
		if (newTarget < 0)
			return;
		for (int i = cur; i < candidates.length; i++) {
			result.add(candidates[i]);
			findResult(candidates, i, newTarget - candidates[i], result, finalResult);
			result.remove(result.size() - 1);
		}
	}

}
