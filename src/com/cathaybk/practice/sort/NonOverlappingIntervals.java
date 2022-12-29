package com.cathaybk.practice.sort;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        int last = intervals[0][1];
        int result = 0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]>= last){
                last = intervals[i][1];
            } else {
                result++;
                last = Math.min(last, intervals[i][1]);
            }
        }

        return result;
    }
}
