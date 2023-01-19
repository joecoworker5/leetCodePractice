package com.cathaybk.practice.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

}
