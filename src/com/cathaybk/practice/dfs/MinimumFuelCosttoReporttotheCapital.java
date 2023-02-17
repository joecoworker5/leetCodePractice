package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CloneGraph {

    public Node cloneGraph(Node node) {
        Map<Integer, Node> memo = new HashMap<>();
        return dfs(node, memo);
    }

    Node dfs(Node node, Map<Integer, Node> memo){
        if(node==null){
            return null;
        }
        if(memo.containsKey(node.val)){
            return memo.get(node.val);
        }

        Node newNode = new Node(node.val);
        memo.put(node.val, newNode);
        for(Node n: node.neighbors){
            newNode.neighbors.add(dfs(n, memo));
        }
        
        return newNode;

    }
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}