package com.cathaybk.practice.tree;

public class ConstructBinaryTreefromPreorderandInorder {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder 的 第一個會是 root, 在inorder找到相對應值的 index, 此index左側皆為此root的左側, 右側亦然用
        // recursion 以此類推
        return dfs(0, 0, inorder.length-1, preorder, inorder);
    }

    TreeNode dfs(int preorderIndex, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preorderIndex > preorder.length-1 || inStart > inEnd){
            return null;
        }

        TreeNode node = new TreeNode(preorder[preorderIndex]);
        int inorderIndex = 0;
        for(int i=inStart; i<=inEnd; i++){
            if(preorder[preorderIndex]==inorder[i]){
                inorderIndex = i;
            }
        }

        node.left = dfs(preorderIndex+1, inStart, inorderIndex-1, preorder, inorder);
        node.right = dfs(preorderIndex+(inorderIndex-inStart)+1, inorderIndex + 1, inEnd, preorder, inorder);
        return node;
    }
}
