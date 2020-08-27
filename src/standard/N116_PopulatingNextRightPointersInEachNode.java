package standard;

import bean.Node;

/**
 * 假设当前遍历的一层已经连接好了，那你把这层下面的孩子全连接起来不完了
 * 因为root肯定是连接好的，它只有一个节点
 */
public class N116_PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        Node node = root;
        while (node != null && node.left != null) {
            Node cur = node;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {

    }
}
