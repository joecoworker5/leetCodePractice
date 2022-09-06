package com.cathaybk.practice.dp;

public class BestTimetoBuyandSellStockwithCooldown {

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 0, 2 };
		int result = new BestTimetoBuyandSellStockwithCooldown().maxProfit(prices);
		System.out.println(result);
	}

	// dp 四種狀態
	public int maxProfit2(int[] prices) {
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
				dp[i][0] = -prices[i] + dp[i - 1][2];
				dp[i][1] = prices[i] + Math.max(dp[i - 1][0], dp[i - 1][3]);
				dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
				dp[i][3] = Math.max(dp[i - 1][0], dp[i - 1][3]);
			}
		}

		return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
	}

	// dp 三種狀態
	public int maxProfit(int[] prices) {
		if (prices.length == 1) {
			return 0;
		}
		/*
		 * 0:持有 1:休息 2賣
		 * 持有包刮三種情況: 昨天持有，前天休息昨天買，昨天休息今天買
		 */
		int[][] dp = new int[prices.length][3];
		dp[0][1] = 0;
		dp[0][0] = -prices[0];
		dp[1][0] = Math.max(dp[0][0], -prices[1]);
		dp[1][2] = dp[0][0] + prices[1];
		dp[1][1] = 0;
		for (int i = 2; i < prices.length; i++) {
			dp[i][2] = dp[i - 1][0] + prices[i];
			dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][1]);
			dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i - 1]), dp[i - 1][1] - prices[i]);
		}

		return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
	}
}
