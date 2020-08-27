package standard;

import bean.Node;

public class N117_PopulatingNextRightPointersInEachNodeII {

    public Node connect(Node root) {
        Node node = root; // 当前访问的层节点
        Node dummy = new Node(0); // 下一层的初始节点
        Node cur = dummy; // 当前访问的下一层节点
        while (null != node) {
            if (null != node.left) {
                cur.next = node.left;
                cur = node.left;
            }
            if (null != node.right) {
                cur.next = node.right;
                cur = node.right;
            }
            node = node.next;
            if (null == node) {
                cur.next = null; // 这里的赋值主要是结束循环，当下一层没有节点时，cur将保持为dummy
                node = dummy.next;
                cur = dummy;
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
