package com.cathaybk.practice.leetCode.tree;

public class InvertBinaryTree {

	public static void main(String[] args) {

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		dfs(root);

		return root;
	}

	void dfs(TreeNode node) {
		if (node == null) {
			return;
		}
		TreeNode left = node.left;
		node.left = node.right;
		node.right = left;
		dfs(node.left);
		dfs(node.right);
	}
}
