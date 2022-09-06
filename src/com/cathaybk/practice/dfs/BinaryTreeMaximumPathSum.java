package com.cathaybk.practice.dfs;

import com.cathaybk.practice.leetCode.tree.TreeNode;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		int result = new BinaryTreeMaximumPathSum().maxPathSum(root);
		System.out.println(result);
	}

	int maxPathSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		if (root.left == null && root.right == null) {
			return root.val;
		}
		dfs(root);
		return maxPathSum;
	}

	int dfs(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = dfs(node.left);
		int right = dfs(node.right);

		maxPathSum = Math.max(maxPathSum, node.val + (left > 0 ? left : 0) + (right > 0 ? right : 0));
		return Math.max(node.val, node.val + Math.max(right, left));
	}
}
