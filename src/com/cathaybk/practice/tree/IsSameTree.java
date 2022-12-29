package com.cathaybk.practice.leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsSameTree {

	public static void main(String[] args) {

	}
	
	//recursion
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	// iterate 最後一個case失敗，找不到原因
	public boolean isSameTreeIterate(TreeNode p, TreeNode q) {
		List<Integer> resultOne = levelorderTraversal(p);
		List<Integer> resultTwo = levelorderTraversal(q);
		if (resultOne.size() != resultTwo.size()) {
			return false;
		}
		int i = 0;
		while (i < resultOne.size()) {
			if (resultOne.get(i) != resultTwo.get(i))
				return false;
			i++;
		}

		return true;
	}

	// iterate
	public List<Integer> levelorderTraversal(TreeNode root) {
		List<Integer> levelorderList = new ArrayList<>();
		Queue<TreeNode> list = new LinkedList<>();
		TreeNode current = root;
		list.add(current);
		while (list.stream().anyMatch(e -> e != null)) {
			levelorderList.add(current != null ? current.val : null);
			list.add(current != null ? current.left : null);
			list.add(current != null ? current.right : null);
			list.poll();
			current = list.peek();
		}

		return levelorderList;
	}

}
