package com.cathaybk.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromebyConcatenatingTwoLetterWords {

    public int longestPalindromeWithOutMap(String[] words) {
        int counter[][] = new int[26][26];
        int ans = 0;
        for (String w: words) {
            int a = w.charAt(0) - 'a', b = w.charAt(1) - 'a';
            if (counter[b][a] > 0) {
                ans += 4; 
                counter[b][a]--; 
            }
            else counter[a][b]++;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i][i] > 0) {
                ans += 2;
                break;
            }
        }
        return ans;
    }

    public int longestPalindromeWithMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int maxLength = 0;
        for(String s : words){
            String reverse = reverse(s);
            if(map.containsKey(reverse)){
                map.put(reverse, map.get(reverse)-1);
                maxLength +=4;
                if(map.get(reverse)==0) {
                    map.remove(reverse);
                }
            } else {
                map.put(s, map.getOrDefault(s,0)+1);
            }
        }

        for(String key: map.keySet()){
            if(key.equals(reverse(key))){
                maxLength +=2;
                break;
            }
        }

        return maxLength;
    }

    public String reverse(String s){
        String[] strArr = s.split("");
        return strArr[1]+strArr[0];
    }


}
