package com.cathaybk.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {

	}
	
	//recursion
	public TreeNode sortedArrayToBST(int[] nums) {
        int end = nums.length -1;
        return dfs(0, end, nums);
    }

    TreeNode dfs(int start, int end, int[] nums){
        if(start<0 || end>=nums.length || start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = dfs(start, mid-1,nums);
        TreeNode right = dfs(mid+1, end, nums);
        root.left =  left;
        root.right = right;
        return root;
    }

}
