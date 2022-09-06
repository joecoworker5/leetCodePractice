package com.cathaybk.practice.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "pwwkew";
		int result = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
		System.out.println(result);
	}

	public int lengthOfLongestSubstring(String s) {
		char[] charArray = s.toCharArray();
		if (charArray.length == 0) {
			return 0;
		}
		Queue<Character> list = new LinkedList<>();
		int max = 1;
		for (int i = 0; i < charArray.length; i++) {
			if (list.contains(charArray[i])) {
				max = list.size() > max ? list.size() : max;
				while (list.peek() != charArray[i]) {
					list.poll();
				}
				list.poll();
				list.add(charArray[i]);
			} else {
				list.add(charArray[i]);
			}
		}

		return max = list.size() > max ? list.size() : max;
	}

}
