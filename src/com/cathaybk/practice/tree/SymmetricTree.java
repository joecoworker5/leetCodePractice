package com.cathaybk.practice.leetCode.tree;

public class BinaryTreeCameras {

	public static void main(String[] args) {

	}

	int minimumCameraNum = 0;

	public int minCameraCover(TreeNode root) {
		/**
		 * 1.有camera 2.沒camera, 需要camera 3.沒camera, 不須camera
		 */
        if (root == null) return 0;
		int status = dfs(root);
		if(status==2) {
			minimumCameraNum++;
		}

		return minimumCameraNum;
	}

	int dfs(TreeNode node) {
		if (node == null) {
			return 3;
		}
		int leftStatus = dfs(node.left);
		int rightStatus = dfs(node.right);
		if (leftStatus == 2 || rightStatus == 2) {
			minimumCameraNum++;
			return 1;
		}
		if (leftStatus == 3 && rightStatus == 3) {
			return 2;
		}

		return 3;
	}
}
