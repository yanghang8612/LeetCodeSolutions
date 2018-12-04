import bean.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        return deleteDuplicates(head, head.val - 1);
    }

    private ListNode deleteDuplicates(ListNode node, int preVal) {
        if (node.next == null) return node.val == preVal ? null : node;
        if (node.val == node.next.val || node.val == preVal)
            return deleteDuplicates(node.next, node.val);
        else {
            node.next = deleteDuplicates(node.next, node.val);
            return node;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNext(1).addNext(2).addNext(2).addNext(3).addNext(3).addNext(3).addNext(3);
        ListNode.printNodes(head);
        ListNode.printNodes(new RemoveDuplicatesFromSortedListII().deleteDuplicates(head));
    }
}
