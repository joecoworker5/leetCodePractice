package com.cathaybk.practice.prioirtyQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class RemoveStonestoMinimizetheTotal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lsit = new ArrayList<>();
	}

	public int minStoneSum(int[] piles, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		int res = 0;
		for (int i = 0; i < piles.length; i++) {
			res += piles[i];
			pq.add(piles[i]);
		}

		while (k-- > 0) {
			Integer max = pq.poll();
			pq.add(max - max / 2);
			res -= max / 2;
		}
		return res;

	}
}
