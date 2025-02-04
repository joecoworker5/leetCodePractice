package com.cathaybk.practice.structureDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.cathaybk.practice.leetCode.tree.TreeNode;



public class BinarySearchTreeIterator {

    private final Stack<TreeNode> stack;
    
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        
        // Traversal cur node's right branch
        TreeNode cur = node.right;
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        
        return node.val;
    }
}

class BSTIterator {

    private final List<TreeNode> list = new ArrayList<>();
    private int pointer = -1;

    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    void dfs(TreeNode node){
        if(node!=null){
            dfs(node.left);
            list.add(node);
            dfs(node.right);
        }
    }

    public int next() {
        pointer++;
        if(list.size()-1>=pointer){
            return list.get(pointer).val;
        }
        return -1;
    }

    public boolean hasNext() {
        return list.size()-1>=pointer+1;
    }
