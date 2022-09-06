package com.cathaybk.practice.dfs;

public class UglyNumber {

	public static void main(String[] args) {
		boolean result = new UglyNumber().isUgly(31);
		System.out.println(result);
	}

	// dfs
	public boolean isUgly1(int n) {
		if (n <= 0) {
			return false;
		}
		int[] divident = { 2, 3, 5 };
		return dfs(n, 0, divident);
	}

	boolean dfs(int quotient, int rest, int[] divident) {
		if (quotient == 1 && rest == 0) {
			return true;
		}
		if (rest != 0) {
			return false;
		}
		for (int i = 0; i < divident.length; i++) {
			if (dfs(quotient / divident[i], quotient % divident[i], divident)) {
				return true;
			}
		}

		return false;
	}

	public boolean isUgly(int n) {
		if (n <= 0) {
			return false;
		}
		int[] divident = { 2, 3, 5 };
		boolean[] dp = new boolean[n + 1];
		dp[1] = true;
		for (int i = 1; i < dp.length; i++) {
			if (dp[i]) {
				for (int j = 0; j < divident.length; j++) {
					if (i * divident[j] < n + 1)
						dp[i * divident[j]] = true;
				}
			}

		}

		return dp[n];
	}

}
