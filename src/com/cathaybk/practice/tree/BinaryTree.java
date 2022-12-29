package com.cathaybk.practice.leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	TreeNode root;
	Queue<Integer> queue = new LinkedList<Integer>();
	public BinaryTree() {
	}

	public BinaryTree(TreeNode root) {
		this.root = root;
	}

	List<Integer> inorderList = new ArrayList<>();

	List<Integer> preorderList = new ArrayList<>();

	List<TreeNode> levelorder = new ArrayList<>();
	List<Integer> levelorderResult = new ArrayList<>();

	// resursion
	public List<List<Integer>> levelorderTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		traverse(root, 1, result);
		return result;
	}

	void traverse(TreeNode root, int level, List<List<Integer>> result) {
		if (root == null)
			return;

		if (level > result.size())
			result.add(new ArrayList<>());

		result.get(level - 1).add(root.val);
		traverse(root.left, level + 1, result);
		traverse(root.right, level + 1, result);
	}

	// iterate fail at last case
	// public List<Integer> levelorderTraversalIterate(TreeNode root) {
	// 	List<Integer> levelorderList = new ArrayList<>();
	// 	Queue<TreeNode> list = new LinkedList<>();
	// 	TreeNode current = root;
	// 	list.add(current);
	// 	while (list.stream().anyMatch(e -> e != null)) {
	// 		levelorderList.add(current != null ? current.val : null);
	// 		list.add(current != null ? current.left : null);
	// 		list.add(current != null ? current.right : null);
	// 		list.poll();
	// 		current = list.peek();
	// 	}

	// 	return levelorderList;

	// }

	// iterate 
	public static void levelOrderTraversal(TreeNode startNode) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(startNode);
		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			System.out.printf("%d ", tempNode.val);
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
	}

	// recursion
	public List<Integer> preorderTraversal(TreeNode root) {
		TreeNode current = root;
		if (current != null) {
			preorderList.add(current.val);
			preorderTraversal(current.left);
			preorderTraversal(current.right);
		}
		return preorderList;
	}

	// iterate
	public void preorderTraversaliterate(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			System.out.println(curr.val);
			if (curr.right != null)
				stack.push(curr.right);
			if (curr.left != null)
				stack.push(curr.left);
		}
	}

	// recursion
	public List<Integer> inorderTraversal(TreeNode root) {
		TreeNode current = root;
		if (current != null) {
			inorderTraversal(root.left);
			inorderList.add(root.val);
			inorderTraversal(root.right);
		}

		return inorderList;

	}

	// iterate
	public List<Integer> inorderTraversalIterate(TreeNode root) {
		TreeNode p = root;
		List<Integer> inorder = new ArrayList<>();
		Stack<TreeNode> list = new Stack<>();
		while (p != null || !list.isEmpty()) {
			while (p != null) {
				list.push(p);
				p = p.left;
			}

			p = list.pop();
			inorder.add(p.val);
			p = p.right;
		}

		return inorder;

	}
}
