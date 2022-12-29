package com.cathaybk.practice.leetCode.tree;

public class DistributeCoinsinBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.left.right = new TreeNode(3);
		int result = new DistributeCoinsinBinaryTree().distributeCoins(root);
		System.out.println(result);
	}

	int distributeNum = 0;

	public int distributeCoins(TreeNode root) {
		dfs(root);
		return distributeNum;
	}

	public int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.val - 1;
		}

		int leftCoin = dfs(root.left);
		int rightCoin = dfs(root.right);
		distributeNum += Math.abs(leftCoin) + Math.abs(rightCoin);

		return leftCoin + rightCoin + root.val - 1;
	}
}
