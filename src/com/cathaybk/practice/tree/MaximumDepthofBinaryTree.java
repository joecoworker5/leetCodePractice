package com.cathaybk.practice.tree;

import java.util.List;

public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        return dfs(root);
     }
 
     public int dfs(TreeNode node){
         if(node==null){
             return 0;
         }
 
         return Math.max(dfs(node.left), dfs(node.right))+1;
     }

}
