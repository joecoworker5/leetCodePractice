package com.cathaybk.practice.dfs;

public class ValidParentheses {

	public static void main(String[] args) {
		boolean result = new ValidParentheses().isValid("[([]])");
		System.out.println(result);
	}

	public boolean isValid(String s) {
		if (s.isEmpty()) {
			return true;
		} else if (s.length() == 1) {
			return false;
		} else if (!s.contains("{}") && !s.contains("()") && !s.contains("[]")) {
			return false;
		}
		String newString = s.replaceAll("\\(\\)|\\[\\]|\\{\\}", "");
		return isValid(newString);
	}
}
