package com.cathaybk.practice.tree;

public class BinaryTreePruning {

	public TreeNode pruneTree(TreeNode root) {


        if(dfs(root)){
            return root;
        }
        return null;
    }

    boolean dfs(TreeNode node){
        if(node==null){
            return false;
        }

        boolean isLeftPruneTree = dfs(node.left);
        if(!isLeftPruneTree){
            node.left = null;
        }
        boolean isRightPruneTree = dfs(node.right);
        if(!isRightPruneTree){
            node.right = null;
        }
        return node.val == 1 || isLeftPruneTree || isRightPruneTree;
    }
}
