package com.cathaybk.practice.dfs;

import com.cathaybk.practice.leetCode.tree.TreeNode;

public class LongestUnivaluePath {
	int longestUnivaluePath = 0;

	public int longestUnivaluePath(TreeNode root) {

		if (root == null || root.left == null && root.right == null) {
			return longestUnivaluePath;
		}
		dfs(root);
		return longestUnivaluePath;
	}

	int dfs(TreeNode node) {
		int left = 0;
		int right = 0;
		if (node.left != null) {
			left = dfs(node.left);
			left = node.val == node.left.val ? left + 1 : 0;
		}
		if (node.right != null) {
			right = dfs(node.right);
			right = node.val == node.right.val ? right + 1 : 0;
		}

		longestUnivaluePath = Math.max(longestUnivaluePath, left + right);
		return Math.max(right, left);
	}
}
