package com.cathaybk.practice.sort;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 5 } };
		int[] newInterval = { 2, 7 };
		int[][] result = new InsertInterval().insert(intervals, newInterval);
		System.out.println(result);
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length == 0) {
			int[][] min = new int[1][2];
			min[0] = newInterval;
			return min;
		}
		List<int[]> list = new ArrayList<int[]>();
		int start = intervals[0][0];
		if (newInterval[0] <= start) {
			list.add(newInterval);
		}
		list.add(intervals[0]);
		boolean isUsed = false;
		for (int i = 1; i < intervals.length; i++) {
			if (newInterval[0] > start && intervals[i][0] >= newInterval[0]) {
				list.add(newInterval);
				isUsed = true;
			}
			start = intervals[i][0];
			list.add(intervals[i]);
		}
		if (!isUsed) {
			list.add(newInterval);
		}

		return merge(list);

	}

	public int[][] merge(List<int[]> list) {

		List<int[]> newList = new ArrayList<int[]>();
		int startIndex = list.get(0)[0];
		int endIndex = list.get(0)[1];
		for (int[] interval : list) {
			if (interval[0] <= endIndex) {
				endIndex = interval[1] > endIndex ? interval[1] : endIndex;
			} else {
				int[] newInterval = new int[2];
				newInterval[0] = startIndex;
				newInterval[1] = endIndex;
				newList.add(newInterval);
				startIndex = interval[0];
				endIndex = interval[1];
			}
		}
		int[] finalInterval = new int[2];
		finalInterval[0] = startIndex;
		finalInterval[1] = endIndex;
		newList.add(finalInterval);

		return newList.toArray(new int[newList.size()][2]);

	}

}
