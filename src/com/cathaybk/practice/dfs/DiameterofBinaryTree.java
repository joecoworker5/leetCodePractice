package com.cathaybk.practice.dfs;

import com.cathaybk.practice.leetCode.tree.TreeNode;

public class DiameterofBinaryTree {

	public static void main(String[] args) {

	}

	int maxdiameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root.left == null && root.right == null) {
			return maxdiameter;
		}
		dfs(root);
		return maxdiameter;
	}

	int dfs(TreeNode node) {
		if (node == null) {
			return -1;
		}

		int left = dfs(node.left) + 1;
		int right = dfs(node.right) + 1;

		maxdiameter = Math.max(maxdiameter, left + right);
		return Math.max(right, left);
	}
}
