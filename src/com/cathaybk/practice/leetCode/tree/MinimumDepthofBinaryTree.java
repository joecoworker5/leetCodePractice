package com.cathaybk.practice.leetCode.tree;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return dfs(root);

	}

	int dfs(TreeNode node) {
		if (node.left == null && node.right == null) {
			return 1;
		} else if (node.left == null && node.right != null) {
			return 1 + dfs(node.right);
		} else if (node.left != null && node.right == null) {
			return 1 + dfs(node.left);
		} else {
			return 1 + Math.min(dfs(node.left), dfs(node.right));
		}

	}
}
