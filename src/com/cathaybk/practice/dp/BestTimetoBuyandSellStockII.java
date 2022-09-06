package com.cathaybk.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class BestTimetoBuyandSellStockII {

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 4, 5 };
		int result = new BestTimetoBuyandSellStockII().maxProfit(prices);
		System.out.println(result);
	}

	public int maxProfit1(int[] prices) {
		if (prices.length == 1) {
			return 0;
		}
		Map<String, Integer> memo = new HashMap<>();
		return Math.max(dfs(prices, 2, 0, 0, memo), dfs(prices, 0, 1, 0, memo));
	}

	int dfs(int[] prices, int previousStatus, int status, int day, Map<String, Integer> memo) {
		if (memo.containsKey(previousStatus + "," + status + "," + day)) {
			return memo.get(previousStatus + "," + status + "," + day);
		}
		if (day == prices.length - 1) {
			return status == 2 ? prices[prices.length - 1] : 0;
		}

		if (status == 1) {
			int result = -prices[day] + Math.max(dfs(prices, 1, 0, day + 1, memo), dfs(prices, 1, 2, day + 1, memo));
			memo.put(previousStatus + "," + status + "," + day, result);
			return result;
		} else if (status == 2) {
			int result = prices[day] + Math.max(dfs(prices, 2, 0, day + 1, memo), dfs(prices, 2, 1, day + 1, memo));
			memo.put(previousStatus + "," + status + "," + day, result);
			return result;
		} else {
			if (previousStatus == 1) {
				int result = Math.max(dfs(prices, previousStatus, 0, day + 1, memo), dfs(prices, 0, 2, day + 1, memo));
				memo.put(previousStatus + "," + status + "," + day, result);
				return result;
			} else if (previousStatus == 2) {
				int result = Math.max(dfs(prices, previousStatus, 0, day + 1, memo), dfs(prices, 0, 1, day + 1, memo));
				memo.put(previousStatus + "," + status + "," + day, result);
				return result;
			}
		}

		return 0;
	}

	public int maxProfit(int[] prices) {
		if (prices.length == 1) {
			return 0;
		}
		/*
		 * 0:買 1:賣 2:已賣狀態 3:已買狀態
		 */
		int[][] dp = new int[prices.length][4];
		dp[0][0] = -prices[0];
		dp[0][2] = 0;
		for (int i = 1; i < prices.length; i++) {
			if (i == 1) {
				dp[1][0] = -prices[i];
				dp[1][1] = dp[0][0] + prices[i];
				dp[1][2] = 0;
				dp[1][3] = dp[0][0];
			} else {
				dp[i][0] = -prices[i] + Math.max(dp[i - 1][1], dp[i - 1][2]);
				dp[i][1] = prices[i] + Math.max(dp[i - 1][0], dp[i - 1][3]);
				dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
				dp[i][3] = Math.max(dp[i - 1][0], dp[i - 1][3]);
			}
		}

		return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
	}
}
