import bean.ListNode;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) {
            if (head.val > head.next.val) {
                int temp = head.val;
                head.val = head.next.val;
                head.next.val = temp;
            }
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = sortList(slow.next);
        slow.next = null;
        slow = sortList(head);
        head = new ListNode(Integer.MIN_VALUE);
        ListNode node = head;
        while (slow != null || fast != null) {
            if (fast == null || (slow != null && slow.val <= fast.val)) {
                node = node.next = slow;
                slow = slow.next;
            } else {
                node = node.next = fast;
                fast = fast.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.addNext(2).addNext(4);
        ListNode.printNodes(new SortList().sortList(node));
    }
}
