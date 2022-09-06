package com.cathaybk.practice.leetCode;

import java.util.HashSet;
import java.util.Set;

public class CoinChange {

	public static void main(String[] args) {
	}

	public int coinChange(int[] coins, int amount) {
		Set<Integer> remains = new HashSet<>();
		int lowestCount = 0;
		if (amount == 0) {
			return 0;
		}

		for (int i = 0; i < coins.length; i++) {
			if (amount - coins[i] > 0 && !remains.contains(amount - coins[i])) {
				int count = coinChange(coins, amount - coins[i]);
				if (remain == 0) {
					return count;
				}
				remains.add(amount - coins[i]);
			}
		}
		return lowestCount;
	}
}
