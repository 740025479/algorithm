package org.wy.dataStructure.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

public class Num133 {


    private HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (map.get(node) != null) {
            return map.get(node);
        }

        Node newNode = new Node(node.val,new ArrayList<>());
        map.put(node,newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;

    }


}
