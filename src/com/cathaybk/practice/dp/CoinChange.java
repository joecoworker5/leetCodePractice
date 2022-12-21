package com.cathaybk.practice.dp;

import java.util.HashMap;
import java.util.Map;

class CoinChange {

    //dfs
    public int coinChangeDfs(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(coins, amount, memo);
    }

    Integer dfs(int[] coins, Integer amount, Map<Integer, Integer> memo){
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        if(amount ==0){
            return 0;
        } else if (amount <0){
            return -1;
        }


        int minCoinCount = -1;
        for(int i=0; i<coins.length; i++){
            Integer result = dfs(coins, amount - coins[i], memo);
            if(result>=0){
                minCoinCount = (minCoinCount == -1 || minCoinCount > result+1) ? result+1 : minCoinCount;
            }
        }
        memo.put(amount, minCoinCount);
        return minCoinCount;
    }

    //dp: tabulation
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 0; i < amount+1; i++){
            dp[i]=-1;
        }
        dp[0] = 0;
        for(int i=0; i<amount+1; i++){
            if(dp[i]!=-1){
                for(int coin: coins){
                    if(i+coin<=amount && i+coin>=0){
                        dp[i+coin] = (dp[i+coin]==-1 || dp[i+coin]> (dp[i]+1)) ? (dp[i]+1) : dp[i+coin];
                    }
                }
            }
        }

        return dp[amount];
    }

}
