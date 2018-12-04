import bean.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode one = head, two = head;
        while (one != null && two != null) {
            one = one.next;
            two = two.next == null ? null : two.next.next;
            if (one == two) break;
        }
        return two != null && one == two;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(1);
        node.next = node1;
        node1.next = node;
        System.out.println(new LinkedListCycle().hasCycle(node));
    }
}
