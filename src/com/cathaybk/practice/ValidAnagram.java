package com.cathaybk.practice;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagarad";
		boolean result = new ValidAnagram().isAnagram(s, t);
		System.out.println(result);
	}

	public boolean isAnagram(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (Character c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				Integer count = map.get(c);
				map.put(c, ++count);
			}
		}

		for (Character c : t.toCharArray()) {
			if (!map.containsKey(c)) {
				return false;
			} else {
				Integer count = map.get(c);
				map.put(c, --count);
			}
		}

		for (Integer count : map.values()) {
			if (count != 0) {
				return false;
			}
		}

		return true;
	}
}
