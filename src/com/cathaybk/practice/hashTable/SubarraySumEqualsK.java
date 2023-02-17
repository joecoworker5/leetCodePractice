package com.cathaybk.practice.hashTable;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0; int result = 0;
        // key: sum, value: count
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        //key concept: sum(i, j)(k) = sum(0, j) - sum(0, i-1) => sum(0, i-1) = sum(0, j) - k
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                result += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return result;
    }
}
