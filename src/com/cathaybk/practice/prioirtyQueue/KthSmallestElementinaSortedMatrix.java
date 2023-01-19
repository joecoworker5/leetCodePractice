package com.cathaybk.practice.prioirtyQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {

	public int kthSmallestBetterPriorityQueue(int[][] matrix, int k) {

		// max heap
		//Time Complexity: N * log(K) //N== n^2
		// Auxiliary Space Complexity: O(K)
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		 
		 int n = matrix.length;
		 
		 for(int i = 0;i<n;i++){
			 for(int j = 0;j<n;j++){
				 if(pq.size() < k){
					 pq.add(matrix[i][j]);
				 }else{ //equal to k
					 if(matrix[i][j] < pq.peek()){ //if incoming element is less than peek
						 pq.poll();
						 pq.add(matrix[i][j]);
					 }
				 }
			 }
		 }
		 
		 return pq.peek();
	 }

	public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2)-> o1-o2);
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                p.add(matrix[i][j]);
            }
        }

        while(!p.isEmpty()){
            Integer poll = p.poll();
            if(--k==0){
                return poll;
            }
        }

        return -1;
    }

	public int kthSmallestBinarySearch(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        
        int lo = matrix[0][0], hi = matrix[rows - 1][cols - 1] ;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  maxNum = lo;
           
            for (int r = 0, c = cols - 1; r < rows; r++) {
                while (c >= 0 && matrix[r][c] > mid) c--;   
                
                if (c >= 0) {
                    count += (c + 1); // count of nums <= mid in matrix
                    maxNum = Math.max(maxNum, matrix[r][c]); 
         // mid might be value not in  matrix, we need to record the actually max num;
                }else{ //it means c < 0
                    break;
                } 
            }
            
            // adjust search range
            if (count == k) return maxNum;
            else if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}
