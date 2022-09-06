package com.cathaybk.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class BullsandCows {

	public static void main(String[] args) {
		String secret = "1123";
		String guess = "0111";
		String result = new BullsandCows().getHint(secret, guess);
		System.out.println(result);
	}

	public String getHint(String secret, String guess) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < secret.length(); i++) {
			char s = secret.charAt(i);
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				Integer count = map.get(s);
				map.put(s, ++count);
			}
		}

		int bulls = 0;
		int cows = 0;
		for (int i = 0; i < guess.length(); i++) {
			char c = guess.charAt(i);
			if (map.containsKey(c)) {
				Integer count = map.get(c);
				count--;
				cows++;
				if (count == 0) {
					map.remove(c);
				} else {
					map.put(c, count);
				}
			}

			if (secret.charAt(i) == guess.charAt(i)) {
				bulls++;
				cows--;
			}
		}

		return String.format("%sA%sB", bulls, cows);
	}
}
