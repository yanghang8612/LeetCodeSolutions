package bean;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode addNext(int x) {
        this.next = new ListNode(x);
        return this.next;
    }
    public ListNode addNext(ListNode next) {
        this.next = next;
        return this;
    }

    public static void printNodes(ListNode node) {
        if (node == null) System.out.println("null");
        else {
            do {
                System.out.print(node.val + " ");
            } while ((node = node.next) != null);
            System.out.println();
        }
    }
}
