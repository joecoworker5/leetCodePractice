package com.cathaybk.practice.dfs;
public class DecodeString {

	public String decodeString(String s) {
		int leftCount = 0;
		int leftIndex = -1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isInteger(c)) {
				continue;
			} else if (c == '[') {
				if (i > leftIndex && leftCount == 0) {
					leftIndex = i;
				}
				leftCount++;
			} else if (c == ']') {
				leftCount--;
				if (leftCount == 0) {
					String subStr = s.substring(leftIndex + 1, i);
					int leftNumIndex = leftIndex - 1;
					while (leftNumIndex >= 0 && isInteger(s.charAt(leftNumIndex))) {
						leftNumIndex--;
					}
					int times = Integer.parseInt(s.substring(leftNumIndex + 1, leftIndex));
					String innerString = decodeString(subStr);
					while (times-- > 0) {
						sb.append(innerString);
					}

				}
			} else if (leftCount == 0) {
				sb.append(c);
			}
		}

		return sb.toString();

	}

	public boolean isInteger(char s) {
		try {
			Integer.parseInt(String.valueOf(s));
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}
}
