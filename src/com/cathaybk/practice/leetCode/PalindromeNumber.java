package com.cathaybk.practice.leetCode;

public class PalindromeNumber {

	public static void main(String[] args) {
		boolean result = new PalindromeNumber().isPalindrome(121);
		System.out.println(result);
	}

	public boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		int leftmostIndex = 0;
		int rightmostIndex = s.length() - 1;
		while (leftmostIndex < rightmostIndex) {
			if (s.charAt(leftmostIndex) != s.charAt(rightmostIndex)) {
				return false;
			}
			leftmostIndex++;
			rightmostIndex--;

		}

		return true;
	}
}
