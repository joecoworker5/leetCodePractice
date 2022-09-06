package com.cathaybk.practice.dfs;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins = { 1, 2147483647 };

		int result = new CoinChange().coinChange(coins, 2);
		System.out.println(result);
	}

	public int coinChange1(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		return dfs(coins, amount, map);
	}


	int dfs(int[] coins, int amount, Map<Integer, Integer> map) {
		if (map.containsKey(amount)) {
			return map.get(amount);
		}
		if (amount == 0)
			return 0;

		if (amount < 0) {
			return -1;
		}
		int result = -1;

		for (int i = 0; i < coins.length; i++) {
			int remainder = amount - coins[i];
			int num = dfs(coins, remainder, map);
			if (num >= 0) {
				num++;
				result = (result == -1 || num < result) ? num : result;
			}
		}
		map.put(amount, result);
		return result;
	}

	public int coinChange(int[] coins, int amount) {
		int[] result = new int[amount + 1];
		for (int i = 0; i <= amount; i++)
			result[i] = -1;
		result[0] = 0;
		for (int i = 0; i <= amount; i++) {
			if (result[i] != -1) {
				for (int j = 0; j < coins.length; j++) {
					if ((i + coins[j]) > 0 && i + coins[j] <= amount) {
						result[i + coins[j]] = result[i + coins[j]] == -1 || result[i + coins[j]] > (result[i] + 1)
								? result[i] + 1
								: result[i + coins[j]];
					}
				}
			}
		}
		return result[amount];
	}
}
