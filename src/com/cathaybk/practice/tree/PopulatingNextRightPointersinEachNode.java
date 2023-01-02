package com.cathaybk.practice.tree;

public class PopulatingNextRightPointersinEachNode {

	public Node connect(Node root) {
		List<List<Node>> result = new ArrayList<>();
		dfs(root, 1, result);
		Node prev = null;
		for(List<Node> list : result){
			for(Node node : list){
				if(prev!=null){
					prev.next = node;
				}
				prev = node;
			}

			prev = null;
		}
		return root;
   }

   void dfs(Node node, int level, List<List<Node>> result){
	   if(node == null){
		   return;
	   }

	   if(result.size()<level){
		   result.add(new ArrayList<>());
	   }

	   result.get(level-1).add(node);
	   dfs(node.left, level+1, result);
	   dfs(node.right, level+1, result);
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