package com.cathaybk.practice;

import com.cathaybk.practice.leetCode.tree.TreeNode;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {

	}

	int count = 0;

	public int countNodes(TreeNode root) {
		dfs(root);
		return count;
	}

	void dfs(TreeNode node) {
		if (node != null) {
			count++;
			dfs(node.left);
			dfs(node.right);
		}
	}

}
