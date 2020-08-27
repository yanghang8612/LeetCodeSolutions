package standard;

import bean.ListNode;

public class N025_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = null;
        ListNode pre = null, node = head, next;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return null;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null, next;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNext(1).addNext(2).addNext(2).addNext(3).addNext(3).addNext(3).addNext(3);
        ListNode.printNodes(new N025_ReverseNodesInKGroup().reverse(head));
    }
}
