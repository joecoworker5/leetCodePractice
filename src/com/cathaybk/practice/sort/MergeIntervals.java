package com.cathaybk.practice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] result = new MergeIntervals().merge(intervals);
		System.out.println(result);
	}

	public int[][] merge(int[][] intervals) {
		if (intervals.length == 1) {
			return intervals;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		List<int[]> list = new ArrayList<int[]>();
		int startIndex = intervals[0][0];
		int endIndex = intervals[0][1];
		for (int[] interval : intervals) {
			if (interval[0] <= endIndex) {
				endIndex = interval[1] > endIndex ? interval[1] : endIndex;
			} else {
				int[] newInterval = new int[2];
				newInterval[0] = startIndex;
				newInterval[1] = endIndex;
				list.add(newInterval);
				startIndex = interval[0];
				endIndex = interval[1];
			}
		}
		int[] finalInterval = new int[2];
		finalInterval[0] = startIndex;
		finalInterval[1] = endIndex;
		list.add(finalInterval);

		return list.toArray(new int[list.size()][2]);

	}
}
