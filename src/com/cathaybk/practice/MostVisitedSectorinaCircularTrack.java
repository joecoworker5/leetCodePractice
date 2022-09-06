package com.cathaybk.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MostVisitedSectorinaCircularTrack {

	public static void main(String[] args) {
		int n = 7;
		int[] rounds = { 1, 3, 5, 7 };
		List<Integer> mostVisited = new MostVisitedSectorinaCircularTrack().mostVisited(n, rounds);
		System.out.println(mostVisited);
	}

	int max = 0;

	public List<Integer> mostVisited(int n, int[] rounds) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(rounds[0], 1);

		for (int i = 1; i < rounds.length; i++) {
			if (rounds[i] > rounds[i - 1]) {
				for (int j = rounds[i - 1] + 1; j <= rounds[i]; j++) {
					memorize(map, j);
				}
			} else {
				for (int j = rounds[i - 1] + 1; j <= n; j++) {
					memorize(map, j);
				}
				for (int j = 1; j <= rounds[i]; j++) {
					memorize(map, j);
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		for (Integer key : map.keySet()) {
			if (map.get(key) == max) {
				list.add(key);
			}
		}
		Collections.sort(list);
		return list;

	}

	void memorize(Map<Integer, Integer> map, int sector) {
		if (map.containsKey(sector)) {
			Integer count = map.get(sector);
			++count;
			map.put(sector, count);
			max = count > max ? count : max;
		} else {
			map.put(sector, 1);
			max = 1 > max ? 1 : max;
		}
	}

	public List<Integer> mostVisited1(int n, int[] rounds) {
		int len = rounds.length, fr = rounds[0], to = rounds[len - 1];
		List<Integer> res = new ArrayList<>();
		if (to >= fr) { // no circle, such as [1,3,1,2]
			for (int i = fr; i <= to; i++)
				res.add(i);
		} else { // cross a circle, such as [2,3,2,1]
			for (int i = fr; i <= n; i++) {
				res.add(i);
			}
			for (int i = 1; i <= to; i++) {
				res.add(i);
			}
		}
		Collections.sort(res);
		return res;
	}

}
