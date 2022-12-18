package com.cathaybk.practice.dfs;

import java.util.HashSet;
import java.util.Set;

import com.cathaybk.practice.leetCode.tree.TreeNode;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;
        for (int num : nums){
            int left = num - 1;
            int right = num + 1;
            while (set.remove(left)){
                left--;
            }
            while (set.remove(right)){
                right++;
            }
            longest = Math.max(longest, right - left - 1);
            if(set.isEmpty()) { break;}
        }
        return longest;
    }

	public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longestSofar = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) continue;
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
            longestSofar = Math.max(longestSofar, count);
        }
        return longestSofar;
    }
}
