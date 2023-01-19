package com.cathaybk.practice.hashTable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            Integer remain = target - nums[i];
            if (!map.containsKey(nums[i])){
                map.put(remain, i);
            } else {
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            }
        }

        return result;
    }
}
