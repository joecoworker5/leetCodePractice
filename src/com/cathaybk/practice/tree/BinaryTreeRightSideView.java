package com.cathaybk.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 1);
        return list;
    }
    
    void dfs(TreeNode node,  List<Integer> list, int level){
        if(node == null){
            return;
        }
        if(level>list.size()){
            list.add(node.val);
        }
        
        dfs(node.right, list, level+1);
        dfs(node.left, list, level+1);
    }
}
