package com.cathaybk.practice.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryPreorderTraversal {

    List<Integer> inorderList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root.right = node1;
        node1.left = new TreeNode(3);

        List<Integer> result = new BinaryTree().preorderTraversal(root);
        System.out.println(result);
    }

}
