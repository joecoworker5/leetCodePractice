package com.cathaybk.practice.leetCode;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "ac";
		String result = new LongestPalindromicSubstring().longestPalindrome(s);
		System.out.println(result);
	}

	
	//O(N^2) 太慢
	public String longestPalindrome(String s) {
		String result = "";
		if (s.isEmpty()) {
			return result;
		}
		result = String.valueOf(s.charAt(0));
		for (int i = 0; i < s.length(); i++) {
			char content = s.charAt(i);
			for (int j = i + 1; j < s.length(); j++) {
				if (result.length() >= s.length()) {
					break;
				}
				if (content == s.charAt(j)) {
					result = checkIfLongestPalindrome(i, j, s, result);
				}
			}
		}

		return result;
	}

	String checkIfLongestPalindrome(int i, int j, String s, String result) {
		boolean isPalindrome = true;
		for (int z = i; z <= j; z++) {
			if (s.charAt(z) != s.charAt((j + i) - z)) {
				isPalindrome = false;
				break;
			}
			;
		}

		if (isPalindrome) {
			result = (j - i + 1) > result.length() ? s.substring(i, j + 1) : result;
		}
		return result;

	}

}
