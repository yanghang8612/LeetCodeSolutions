import bean.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(val - 1);
        dummyHead.next = head;
        ListNode node = dummyHead;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElementsRecursive(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {

    }
}
