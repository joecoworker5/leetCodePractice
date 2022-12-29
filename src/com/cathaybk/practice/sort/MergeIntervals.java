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

        if(intervals.length==1){
            return intervals;
        }

        // >0 才swap
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1,
                               int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> result = new ArrayList();

        int beginIndex = intervals[0][0];
        int lastIndex = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            int[] interval = intervals[i];
            if(interval[0]>lastIndex){
                int[] range= {beginIndex, lastIndex};
                result.add(range);
                beginIndex = interval[0];
                lastIndex = interval[1];
            } else {
                lastIndex = Math.max(lastIndex, interval[1]);
            }
            if(i==intervals.length-1) {
                int[] finalRange = {beginIndex, lastIndex};
                result.add(finalRange);
            };
        }
        return result.toArray(new int[result.size()][2]);
    }
}
