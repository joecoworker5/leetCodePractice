package com.cathaybk.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class LongestUnivaluePath {

    int maximum = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maximum;
    }

    int dfs(TreeNode node){
        if(node==null){
            return 0;
        }

        int leftLongest = 0;
        int rightLongest = 0;
        if(node.left!=null){
            int dfsLeft = dfs(node.left);
            if(node.left.val == node.val){
                leftLongest = 1 + dfsLeft;
            } else {
                leftLongest = 0;
            }
        }

        if(node.right!=null){
            int dfsRight = dfs(node.right);
            if(node.right.val == node.val){
                rightLongest = 1 + dfsRight;
            } else {
                rightLongest = 0;
            }
        }

        maximum = Math.max(maximum, leftLongest+rightLongest);

        return Math.max(rightLongest,leftLongest);
    }
}
