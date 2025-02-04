package com.cathaybk.practice.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PathSumIII {

	//https://leetcode.com/problems/path-sum-iii/solutions/91878/17-ms-o-n-java-prefix-sum-method/
    public int pathSum(TreeNode root, int sum) {
        HashMap<Long, Integer> preSum = new HashMap();
        preSum.put(0L,1);
        return helper(root, 0L, sum, preSum);
    }

    public int helper(TreeNode root, Long currSum, int target, HashMap<Long, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        // update the prefix sum by adding the current val
        currSum += root.val;

        // get the number of valid path, ended by the current node
        int res = preSum.getOrDefault(currSum - target, 0);

        // update the map with the current sum, so the map is good to be passed to the next recursion
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        // add the 3 parts discussed in 8. together
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);

        // restore the map, as the recursion goes from the bottom to the top
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
