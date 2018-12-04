import bean.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode node = head, sortedHead = new ListNode(Integer.MIN_VALUE);
        while (node != null) {
            ListNode cur = sortedHead, pre = sortedHead;
            while (cur != null && cur.val < node.val) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = node;
            node = node.next;
            pre.next.next = cur;
        }
        return sortedHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.addNext(1).addNext(2).addNext(4);
        ListNode.printNodes(new InsertionSortList().insertionSortList(node));
    }
}
