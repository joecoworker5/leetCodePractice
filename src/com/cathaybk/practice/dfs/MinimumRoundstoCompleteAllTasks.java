package com.cathaybk.practice.dfs;

import java.util.HashMap;
import java.util.Map;


public class MinimumRoundstoCompleteAllTasks {

	public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int task: tasks){
            if(map.containsKey(task)){
                Integer count = map.get(task);
                map.put(task, ++count);
            } else {
                map.put(task, 1);
            }
        }
        for(int count: map.values()){
            if(count==1){
                return -1;
            }
        }

        int minRounds = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        for(int count: map.values()){
            minRounds += dfs(count, memo);
        }
        
        return minRounds;
    }

   int dfs(int count, Map<Integer, Integer> memo){
        if(memo.containsKey(count)){
            return memo.get(count);
        }
        if(count<0){
            return -1;
        }
        if (count == 0) {
            return 0;
        }

        int result1 = dfs(count - 2, memo);
        if(result1 != -1){
            result1 = result1 + 1;
        }
        int result2 = dfs(count - 3, memo);
        if(result2 != -1){
            result2 = result2 + 1;
        }

        int finalResult;
        if(result1 !=-1 && result2 != -1){
            finalResult = Math.min(result1, result2);
        } else if (result1 != -1){
            finalResult = result1;
        } else if(result2 != -1){
            finalResult = result2;
        } else {
            finalResult = -1;
        }

        memo.put(count, finalResult);
        return finalResult;
    }
}
