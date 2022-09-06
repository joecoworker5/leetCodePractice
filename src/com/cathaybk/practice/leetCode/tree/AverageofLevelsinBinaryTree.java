package com.cathaybk.practice.leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AverageofLevelsinBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.right = new TreeNode(7);
		root.right.left = new TreeNode(15);

		List<Double> result = new AverageofLevelsinBinaryTree().averageOfLevels1(root);
		System.out.println(result);
	}

	// solution 1
	public List<Double> averageOfLevels(TreeNode root) {
		List<List<Double>> result = new ArrayList<>();
		traverse(root, 1, result);
		List<Double> sumResult = new ArrayList<>();
		for (int i = 0; i < result.size(); i++) {
			List<Double> list = result.get(i);
			Double reduce = (double) list.stream().reduce((e, v) -> e + v).get() / (double) list.size();
			sumResult.add(reduce);
		}
		return sumResult;
	}

	void traverse(TreeNode root, int level, List<List<Double>> result) {
		if (root == null)
			return;

		if (level > result.size())
			result.add(new ArrayList<>());

		result.get(level - 1).add(Double.valueOf(root.val));
		traverse(root.left, level + 1, result);
		traverse(root.right, level + 1, result);
	}

	// solution 2
	public List<Double> averageOfLevels1(TreeNode root) {
		List<List<Double>>  result = new ArrayList<>();
		traverse1(root, 1, result);
		return result.stream().map(e-> e.get(1)/e.get(0)).collect(Collectors.toList());
	}

	void traverse1(TreeNode root, int level, List<List<Double>> result) {
		if (root == null)
			return;

		if (level > result.size()) {
			List<Double> list = new ArrayList<>();
			list.add(0, (double) 0);
			list.add(1, (double) 0);
			result.add(list);
		}
		List<Double> list = result.get(level - 1);
		Double count = list.get(0);
		count++;
		Double sum = list.get(1);
		sum += Double.valueOf(root.val);
		list.set(0, count);
		list.set(1, sum);
		result.set(level - 1, list);
		traverse1(root.left, level + 1, result);
		traverse1(root.right, level + 1, result);
	}
}
