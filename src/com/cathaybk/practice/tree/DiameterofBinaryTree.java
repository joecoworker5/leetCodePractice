package com.cathaybk.practice.tree;

public class DiameterofBinaryTree {

    int maximum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maximum;
    }

    private int dfs(TreeNode root) {
        if(root==null){
            return -1;
        }
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        maximum = Math.max(maximum, left + right);
        return Math.max(left, right);

    }
}
