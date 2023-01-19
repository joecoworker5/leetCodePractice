package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.List;


public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> memo = new ArrayList<>();
        dfs(0, s, memo, result);
        return result;
    }

    void dfs(int index, String s, List<String> memo, List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(memo));
            return;
        }
        
        for(int i=index; i<s.length(); i++){
            String subStr = s.substring(index, i + 1);
            if(isPalindrome(subStr)){
                memo.add(subStr);
                dfs(i+1, s, memo, result);
                memo.remove(memo.size()-1);
            }
        }
    }

    boolean isPalindrome(String s){
        if(s.length()==1){
            return true;
        }

        int index = s.length() / 2;
        int remain = s.length() % 2;
        int left;
        int right = index;
        if(remain == 0){
            left = index - 1;
        } else {
            left = index;
        }
        while(left>=0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left--;
            right++;
        }
        return true;

    }
}
