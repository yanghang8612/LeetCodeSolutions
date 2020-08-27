package standard;

import java.util.*;

public class N133_CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    private Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node cloneNode = new Node();
        cloneNode.val = node.val;
        cloneNode.neighbors = new ArrayList<>();
        map.put(cloneNode.val, cloneNode);
        for (Node neighbor : node.neighbors) {
            Node neighborCloneNode;
            if (!map.containsKey(neighbor.val)) {
                neighborCloneNode = cloneGraph(neighbor);
            } else {
                neighborCloneNode = map.get(neighbor.val);
            }
            cloneNode.neighbors.add(neighborCloneNode);
        }
        return cloneNode;
    }

    public static void main(String[] args) {

    }
}
