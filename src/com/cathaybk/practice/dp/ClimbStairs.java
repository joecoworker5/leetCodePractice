package com.cathaybk.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    // dfs time O(2^n) space: O(n)
    // + memo -> time O(N)
    public int climbStairs1(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(n, memo);
    }

    int dfs(Integer n, Map<Integer, Integer> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n==1){
            return 1;
        } else if (n==2){
            return 2;
        }

        int result = dfs(n - 1, memo) + dfs(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    // tabulation
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[0]=1;
        for(int i=0; i<=n; i++){
            if(i+1<=n) {
                arr[i + 1] += arr[i];
            }
            if(i+2<=n) {
                arr[i + 2] += arr[i];
            }
        }
        return arr[n];
    }
}
