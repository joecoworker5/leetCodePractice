package com.cathaybk.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, targetSum, list, result);
        return result;
    }

    public void dfs(TreeNode root, int targetSum,List<Integer> list, List<List<Integer>> result){
        if(root==null){
            return;
        }
        if(root.left == null && root.right == null && targetSum == root.val){
            list.add(root.val);
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(root.val);
        dfs(root.left, targetSum-root.val, list, result);
        list.remove(list.size()-1);
        dfs(root.right, targetSum-root.val, list, result);
        list.remove(list.size()-1);
    }
}
