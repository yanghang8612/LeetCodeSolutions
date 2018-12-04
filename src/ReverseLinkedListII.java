import bean.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = null, node = dummy, next;
        while (n != -1) {
            if (m < 1) {
                next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            } else {
                pre = node;
                head = node = node.next;
            }
            m--;n--;
        }
        head.next.next = pre;
        head.next = node;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.addNext(1).addNext(2).addNext(3).addNext(4).addNext(5).addNext(6).addNext(7);
        ListNode.printNodes(head);
        ListNode.printNodes(new ReverseLinkedListII().reverseBetween(head, 1, 1));
    }
}
