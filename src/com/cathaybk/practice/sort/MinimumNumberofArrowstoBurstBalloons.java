package com.cathaybk.practice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberofArrowstoBurstBalloons {

	// sort time: O(NlogN)
	public int findMinArrowShots(int[][] points) {

		Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

		int minArrowShots = 0;
		int start = points[0][0];
		int end = points[0][1];
		for (int i = 1; i < points.length; i++) {
			int pStart = points[i][0];
			int pEnd = points[i][1];
			if (pStart > end) {
				minArrowShots++;
				start = pStart;
				end = pEnd;
			} else {
				end = Math.min(end, pEnd);
			}
		}

		return minArrowShots + 1;
	}


	   // Finds the minimum number of arrows needed to burst all balloons
	   public int findMinArrowShotsSimilar(int[][] points) {
        // Sort the balloons by the end position of the arrow
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        
        // Initialize the number of arrows needed to 1
        int result = 1;
        // Set the index of the previously burst balloon to 0
        int previous = 0;
        
        // Iterate through all balloons
        for(int current = 1; current < points.length; current++){
            // If the start position of the current balloon is after the end position of the arrow that burst the previous balloon,
            // then a new arrow is needed to burst the current balloon
            if(points[current][0] > points[previous][1]){
                result++;
                // Update the index of the previously burst balloon
                previous = current;
            }
        }
        return result;            
    }
}
