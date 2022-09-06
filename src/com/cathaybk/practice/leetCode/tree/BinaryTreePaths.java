package com.cathaybk.practice.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		List<String> result = new BinaryTreePaths().binaryTreePaths(root);
		System.out.println(result);
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		dfs(root, list, "");
		return list;
	}

	void dfs(TreeNode node, List<String> list, String path) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			list.add(path.length() != 0 ? path + "->" + node.val : String.valueOf(node.val));
			return;
		}

		dfs(node.left, list, path.length() != 0 ? path + "->" + node.val : String.valueOf(node.val));
		dfs(node.right, list, path.length() != 0 ? path + "->" + node.val : String.valueOf(node.val));

	}

}
