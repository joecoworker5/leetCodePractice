package com.cathaybk.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindModeinBinarySearchTree {
	public int[] findMode(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode prev = null;
        int count = 0;
        int maxCount = 0;
        while(p!=null || !stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            TreeNode top = stack.pop();
            //
            if(prev == null || prev.val == top.val){
                count++;
            } else {
                if(count>maxCount){
                    result.clear();
                    result.add(prev.val);
                } else if (count == maxCount){
                    result.add(prev.val);
                }
                maxCount = Math.max(count, maxCount);
                count = 1;
            }
            prev = top;
            //
            p = top.right;
        }

        if(count>maxCount){
            result.clear();
            result.add(prev.val);
        } else if (count == maxCount){
            result.add(prev.val);
        }

        int[] resultInt = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            resultInt[i]=result.get(i);
        }

        return resultInt;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};