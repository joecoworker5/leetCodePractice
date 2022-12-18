package com.cathaybk.practice.dfs;

import java.util.Arrays;

public class LongestCommonPrefix {
	public String longestCommonPrefixDfs(String[] strs) {
		if(strs.length == 1){
			return strs[0];
		}
		if(Arrays.asList(strs).contains("")){
			return "";
		}
 
		
		return dfs("", 0, strs);
	 }
 
	 String dfs(String prefix, Integer i, String[] strs){
		 if(i>=strs[0].length()){
			 return prefix;
		 }
		 char c = strs[0].charAt(i);
		 for(String s: strs){
			 if(i >= s.length() || s.charAt(i)!= c){
				 return prefix;
			 }
		 }
 
		 return dfs(prefix+c, i+1, strs);
	 }



	 ///
	public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for(String s: strs){
            if(s.isEmpty()){
                return "";
            }
            minLength = Math.min(s.length(), minLength);
        }

        int i=0;

        for(;i<minLength; i++){
            char initial = strs[0].charAt(i);
            boolean isBreak = false;
            for(String s: strs){
                if(initial != s.charAt(i)){
                    isBreak = true;
                    break;
                }
            }

            if(isBreak){
                break;
            }
        }

        return strs[0].substring(0, i);
    }
}
