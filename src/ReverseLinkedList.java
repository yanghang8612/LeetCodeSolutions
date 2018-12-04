import bean.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        //if (head == null) return null;
        ListNode pre = null, next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //head.addNext(1).addNext(2).addNext(2).addNext(3).addNext(3).addNext(3).addNext(3);
        ListNode.printNodes(head);
        ListNode.printNodes(new ReverseLinkedList().reverseList(head));
    }
}
