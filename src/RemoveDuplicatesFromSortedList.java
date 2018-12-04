import bean.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNext(1).addNext(2).addNext(3).addNext(3);
        ListNode.printNodes(head);
        ListNode.printNodes(new RemoveDuplicatesFromSortedList().deleteDuplicates(head));
    }
}
