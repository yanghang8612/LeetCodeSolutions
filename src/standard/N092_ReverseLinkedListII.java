package standard;

import bean.ListNode;

public class N092_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy =  new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, next;
        n -= m;
        while (--m > 0) {
            pre = cur;
            cur = cur.next;
        }
        while (n-- > 0) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNext(2).addNext(3).addNext(4).addNext(5);
        ListNode.printNodes(new N092_ReverseLinkedListII().reverseBetween(head, 1, 1));
    }
}
