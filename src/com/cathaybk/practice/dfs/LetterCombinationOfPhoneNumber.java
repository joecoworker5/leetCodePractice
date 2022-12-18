package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

	private static final Map<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
       public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()== 0){
            return new ArrayList<>();
        }
        return letterCombinationDfs(digits, "");
    }

    List<String> letterCombinationDfs(String digits, String current){
        if(digits.length()==0){
            return Collections.singletonList(current);
        }
        String letters = map.get(digits.charAt(0));
        List<String> result = new ArrayList<>();
        for(int i=0; i<letters.length(); i++){
            String newCurrent = current + letters.charAt(i);
            result.addAll(letterCombinationDfs(digits.substring(1), newCurrent));
        }

        return result;
    }
}
