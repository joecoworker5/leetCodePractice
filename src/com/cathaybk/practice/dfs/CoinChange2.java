package com.cathaybk.practice.dfs;

import java.util.HashMap;
import java.util.Map;

public class CoinChange2 {

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int result = new CoinChange2().change(5, coins);
		System.out.println(result);
	}

//	public int coinChange(int[] coins, int amount) {
//		int[] result = new int[amount + 1];
//		result[0] = 1;
//		for (int i = 0; i <= amount; i++) {
//			if (result[i] != 0) {
//				for (int j = 0; j < coins.length; j++) {
//					if ((i + coins[j]) > 0 && i + coins[j] <= amount && i <= coins[j]) {
//						result[i + coins[j]] = result[i + coins[j]] + 1;
//					}
//				}
//			}
//		}
//		return result[amount];
//	}

	
	//resursion + memoization
	public int change(int amount, int[] coins) {
		if (amount == 0) {
			return 1;
		}
		Map<String, Integer> map = new HashMap<>();
		return dfs(coins, amount, map, 0);
	}

	int dfs(int[] coins, int amount, Map<String, Integer> map, int index) {
		if (map.containsKey(amount + "," + index)) {
			return map.get(amount + "," + index);
		}
		if (amount == 0)
			return 1;
		
		int count = 0;
		for (int i = index; i < coins.length; i++) {
			int remainder = amount - coins[i];
			if (remainder >= 0) {
				int result = dfs(coins, remainder, map, i);
				count += result;
			}
			
		}
		// 此時amount和index組合才會是唯一值
		map.put(amount + "," + index, count);
		return count;
	}

}
