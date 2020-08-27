package standard;

public class N138_CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node node = head, next;
        while (node != null) {
            next = node.next;
            node.next = new Node(node.val);
            node.next.next = next;
            node = next;
        }
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        Node newHead = head.next;
        node = head;
        while (node.next != null) {
            next = node.next;
            node.next = node.next.next;
            node = next;
        }
        return newHead;
    }

    public static void main(String[] args) {

    }
}
