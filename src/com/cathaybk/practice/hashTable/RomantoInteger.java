package com.cathaybk.practice.hashTable;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {

	private static Map<String, Integer> map = new HashMap<>();
	static {
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		map.put("IV", 4);
		map.put("IX", 9);
		map.put("XL", 40);
		map.put("XC", 90);
		map.put("CD", 400);
		map.put("CM", 900);
	}

	public static void main(String[] args) {
		int result = new RomantoInteger().romanToInt("MCMXCIV");
		System.out.println(result);
	}

	public int romanToInt(String s) {
		int total = 0;
		int i = 0;
		while (i < s.length()) {
			if ((i < s.length() - 1) && map.containsKey(s.substring(i, i + 2))) {
				total += map.get(s.substring(i, i + 2));
				i = i + 2;
			} else {
				String roman = String.valueOf(s.charAt(i));
				total += map.get(roman);
				i++;
			}
		}

		return total;
	}

}
