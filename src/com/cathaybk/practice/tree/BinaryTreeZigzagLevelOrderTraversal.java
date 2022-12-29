package com.cathaybk.practice.leetCode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(root, 1, result);
		for (int i = 0; i < result.size(); i++) {
			if (i % 2 == 0)
				continue;

			List<Integer> list = result.get(i);
			Collections.reverse(list);
		}
		return result;
	}

	void dfs(TreeNode node, int level, List<List<Integer>> result) {
		if (node == null) {
			return;
		}

		if (level > result.size()) {
			result.add(new ArrayList<>());
		}

		result.get(level - 1).add(node.val);
		dfs(node.left, level + 1, result);
		dfs(node.right, level + 1, result);

	}
}
