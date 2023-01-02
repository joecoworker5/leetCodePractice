package com.cathaybk.practice.tree;

public class RecoverBinarySearchTree {

	public void recoverTree(TreeNode root) {
        TreeNode p = root;
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode first = null;
        TreeNode last = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.add(p);
                p = p.left;
            }
            TreeNode node = stack.pop();
            list.add(node);

        if (list.size() >= 2 && list.get(list.size() - 2).val >                                 list.get(list.size() - 1).val) {
                if (first == null) {
                    first = list.get(list.size() - 2);
                    last = list.get(list.size() - 1);
                }
                else {
                    last = list.get(list.size() - 1);
                    break;
                }
            }
            p = node.right;
        }
        // swap
        Integer tempInt = first.val;
        first.val = last.val;
        last.val = tempInt;
    }
}
