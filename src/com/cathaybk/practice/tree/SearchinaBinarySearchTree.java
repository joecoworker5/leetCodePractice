package com.cathaybk.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SearchinaBinarySearchTree {

	public TreeNode searchBST(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p!=null || !stack.isEmpty()){
            while(p!=null){
                stack.add(p);
                p = p.left;
            }
            TreeNode pop = stack.pop();
            if(pop.val == val){
                return pop;
            }
            p = pop.right;
        }

        return null;
    }

}
