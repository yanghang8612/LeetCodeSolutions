package standard;

import bean.ListNode;

import java.time.Instant;

public class N082_RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-head.val);
        ListNode pre = dummy, node = head, cur = dummy;
        while (node != null) {
            if (node.val != pre.val && (node.next == null || node.val != node.next.val)) {
                cur.next = node;
                cur = node;
            }
            pre = node;
            node = node.next;
        }
        cur.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
