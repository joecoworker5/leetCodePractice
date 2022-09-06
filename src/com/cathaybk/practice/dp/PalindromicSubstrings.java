package com.cathaybk.practice.dp;

public class PalindromicSubstrings {

	public static void main(String[] args) {

	}

	int count = 0;

	public int countSubstrings(String s) {
		if (s.length() == 1) {
			return 1;
		}
		boolean[][] result = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			char start = s.charAt(i);
			for (int j = i; j < s.length(); j++) {
				if (start == s.charAt(j)) {
					checkIfPalindromic(i, j, result);
				}
			}
		}
	}

	void checkIfPalindromic(int left, int right, boolean[][] result) {
		if (left == right) {
			count++;
		}
	}
}
