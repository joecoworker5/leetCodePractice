package com.cathaybk.practice.hashTable;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {

	// map transform to array to store count
	public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }


	// map to store count
	public int firstUniqCharMap(String s) {
        Map<Character,Integer > map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

}
