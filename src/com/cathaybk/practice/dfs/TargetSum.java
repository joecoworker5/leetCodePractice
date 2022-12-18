package com.cathaybk.practice.dfs;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

	public static void main(String[] args) {
		int[] nums = {1 };
		int result = new TargetSum().findTargetSumWays(nums, 1);
		System.out.println(result);
	}

	int count = 0;

	public int findTargetSumWays(int[] nums, int target) {
		dfs(nums, 0, target + nums[0]);
		dfs(nums, 0, target - nums[0]);
		return count;
	}

	void dfs(int[] nums, int index, int target) {
		if (index == nums.length - 1 && target == 0) {
			count++;
			return;
		}
		if (index + 1 < nums.length) {
			dfs(nums, index + 1, target - nums[index + 1]);
			dfs(nums, index + 1, target + nums[index + 1]);
		}
	}

    public int findTargetSumWaysBetter(int[] nums,
                                 int target) {
        Map<String, Integer> memo = new HashMap();
        return dfs(nums, target, 0, memo);
    }

    int dfs(int[] nums,
            int target,
            int index,
            Map<String, Integer> memo) {
        if (memo.containsKey(target + "," + index)) {
            return memo.get(target + "," + index);
        }
        if (index == nums.length && target == 0) {
            return 1;
        }
        if (index == nums.length && target != 0) {
            return 0;
        }

        int countLeft = dfs(nums, target - nums[index], index + 1, memo);
        int countRight = dfs(nums, target + nums[index], index + 1, memo);
        memo.put(target + "," + index, countLeft + countRight);
        return countLeft + countRight;
    }
}
