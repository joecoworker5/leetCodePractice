package com.cathaybk.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinkedList {

	public void flatten(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        dfs(root, result);
        if(result.size()<=1){
            return;
        }
        TreeNode prev = result.get(0);
        for(int i=1; i< result.size(); i++){
            prev.left = null;
            prev.right = result.get(i);
            prev = result.get(i);
        }
    }

    public void dfs(TreeNode node,  List<TreeNode> result) {
        if (node != null) {
            result.add(node);
            dfs(node.left, result);
            dfs(node.right, result);
        }
    }
}
