package com.cathaybk.practice.dp;

class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        dfs(root);
        return maxSum;
    }

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        maxSum = Math.max(maxSum, node.val + (Math.max(left, 0)) + (Math.max(right, 0)));
        return Math.max(node.val, node.val + Math.max(left, right));
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val,
             TreeNode left,
             TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}