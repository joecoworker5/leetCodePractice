package com.cathaybk.practice.dfs;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
		Map<String, Boolean> memo = new HashMap<String, Boolean>();
		return dfs(s1,s2, s3, memo);
	  }
	  
	 boolean dfs(String s1, String s2, String s3, Map<String, Boolean> memo){
			  if(memo.containsKey(s1+s2+s3)){
				  return memo.get(s1+s2+s3);
			  }
			  if("".equals(s1) && "".equals(s2) && "".equals(s3)){
				  return true;
			  } else if("".equals(s3) && (!"".equals(s1) || !"".equals(s2))){
				  return false;
			  }
			  String head = s3.substring(0,1);
			  if(!s1.startsWith(head) && !s2.startsWith(head)){
				  return false;
			  }
			  if(s1.startsWith(head) && s2.startsWith(head)){
				  boolean result = dfs(s1, s2.substring(1), s3.substring(1), memo) || dfs(s1.substring(1), s2, s3.substring(1), memo);
				  memo.put(s1+s2+s3, result);
				  return result;
			  } else if(s1.startsWith(head) && !s2.startsWith(head)){
				  boolean result =dfs(s1.substring(1), s2, s3.substring(1), memo);
				  memo.put(s1+s2+s3, result);
				  return result;
			  } else if(!s1.startsWith(head) && s2.startsWith(head)){
				  boolean result =  dfs(s1, s2.substring(1), s3.substring(1), memo);
				  memo.put(s1+s2+s3, result);
				  return result;
			  }
			  memo.put(s1+s2+s3, false);
			  return false;
		  }

}
