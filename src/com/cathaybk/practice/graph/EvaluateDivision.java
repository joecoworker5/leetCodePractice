package com.cathaybk.practice.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	public static void main(String[] args) {
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> map = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			String x = equations.get(i).get(0);
			String y = equations.get(i).get(1);
			double k = values[i];
			map.computeIfAbsent(x, l -> new HashMap<String, Double>()).put(y, k);
			map.computeIfAbsent(y, l -> new HashMap<String, Double>()).put(x, 1.0 / k);
		}

		double[] ans = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			if (!map.containsKey(queries.get(i).get(0)) || !map.containsKey(queries.get(i).get(0))) {
				ans[i] = -1.0;
				continue;
			}
			ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>(), map);
		}

		return ans;
	}

	double dfs(String x, String y, Set<String> set, Map<String, Map<String, Double>> map) {
		if (x.equals(y))
			return 1.0;

		set.add(x);
		for (String key : map.get(x).keySet()) {
			if (set.contains(key))
				continue;
			set.add(key);
			double result = dfs(key, y, set, map);
			if (result > 0) {
				return result * map.get(x).get(key);
			}
		}

		return -1.0;
	}

}
