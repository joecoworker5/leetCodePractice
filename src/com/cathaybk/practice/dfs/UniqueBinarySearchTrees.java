package com.cathaybk.practice.dfs;

import com.cathaybk.practice.leetCode.linkedList.LinkedList;
import com.cathaybk.practice.leetCode.tree.TreeNode;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {

	}

	public int numTrees(int n) {
		if (n == 1)
			return n;

		new TreeNode();
		for (int i = 1; i <= n; i++) {
			dfs(i, i)
		}
	}
}
