package standard;

import bean.ListNode;

public class N086_PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode left = leftHead, right = rightHead;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        left.next = rightHead.next;
        right.next = null;
        return leftHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
//        head.addNext(3);
        ListNode.printNodes(new N086_PartitionList().partition(head.next, 3));
    }
}
