package com.cathaybk.practice.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.cathaybk.practice.leetCode.tree.TreeNode;

public class AllNodesDistanceKInBinaryTree {

	public static void main(String[] args) {

	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		Map<TreeNode, Integer> dis = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		dis.put(root, 0);
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			TreeNode left = cur.left;
			dis.put(left, dis.get(cur) + 1);
			TreeNode right = cur.right;
		}
	}
}
