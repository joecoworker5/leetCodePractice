package com.cathaybk.practice.tree;

import java.util.Stack;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevNode = null;
        while(p!=null || !stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            TreeNode top = stack.pop();
            if(prevNode!=null && top.val <= prevNode.val){
                return false;
            }
            prevNode = top;
            p = top.right;
        }

        return true;
    }
}
