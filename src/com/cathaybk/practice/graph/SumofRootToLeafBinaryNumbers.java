package com.cathaybk.practice.graph;

import java.util.ArrayList;
import java.util.List;

import com.cathaybk.practice.leetCode.tree.TreeNode;

public class SumofRootToLeafBinaryNumbers {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		int result = new SumofRootToLeafBinaryNumbers().sumRootToLeaf(root);
		System.out.println(result);

	}

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 2 + root.val;
        return root.left == root.right ? val : dfs(root.left, val) + dfs(root.right, val);
    }

}
