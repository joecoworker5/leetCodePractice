package com.cathaybk.practice.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak{

	public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();
        return dfs(s, wordDict, memo);
    }

    boolean dfs(String s, List<String> wordDict, Map<String, Boolean> memo){
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        if(s.isEmpty()){
            return true;
        }

        for(String word: wordDict){
            if(s.startsWith(word)){
                boolean result = dfs(s.substring(word.length()), wordDict, memo);
                memo.put(s.substring(word.length()), result);
                if(result){
                    return true;
                }
            }
        }

        return false;
    }


}
