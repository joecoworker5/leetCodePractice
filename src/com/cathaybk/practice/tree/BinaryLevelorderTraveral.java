package com.cathaybk.practice.leetCode.tree;

import java.util.List;

public class BinaryLevelorderTraveral {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root.right = node1;
        node1.left = new TreeNode(3);

        List<List<Integer>> result = new BinaryTree().levelorderTraversal(root);
        System.out.println(result);
    }

}
