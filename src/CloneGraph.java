import bean.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 图克隆，按照题中给出的结构，我们只需要在遍历的过程中保证每个节点仅被复制一次
 * 主要是因为有环的结构，甭管是自身的环还是两个节点之间的环
 */

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        else return cloneGraph(node, new HashMap<>());
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor, map));
        }
        return newNode;
    }

    public static void main(String[] args) {

    }
}
