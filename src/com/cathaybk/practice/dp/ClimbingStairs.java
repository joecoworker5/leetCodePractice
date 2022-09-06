package com.cathaybk.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

	public static void main(String[] args) {
		int result = new ClimbingStairs().climbStairs(5);
		System.out.println(result);
	}

	public int climbStairs(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		return dfs(n, map);
	}
	//too slow
	int dfs(int n, Map<Integer, Integer> map) {
		if (map.containsKey(n)) {
			return map.get(n);
		}
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		int result = climbStairs(n - 2);
		map.put(n - 2, result);
		return result + dfs(n - 1, map);
	}
	
	public int climbStairs1(int n) {
	    if(n < 0)
	        return 0;
	    if(n == 1)
	        return 1;
	        
	    int[] store = new int[n];
	    
	    store[0] = 1;
	    store[1] = 2;
	    
	    for(int i = 2; i < n; ++i)
	        store[i] = store[i-1] + store[i-2];
	        
	    return store[n-1];
	}

}
