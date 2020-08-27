package standard;

import bean.ListNode;

public class N019_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0), fast = dummy, slow = dummy;
        dummy.next = head;
        while (fast.next != null) {
            if  (--n < 0) slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
