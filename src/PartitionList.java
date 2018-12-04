import bean.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode faker = new ListNode(x);
        faker.next = head;
        ListNode last = faker, preNode = faker;
        while (head != null) {
            if (head.val < x) {
                preNode.next = head.next;
                head.next = last.next;
                last.next = head;
                last = head;
            }
            preNode = head;
            head = head.next;
        }
        return faker.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.addNext(4).addNext(3).addNext(2).addNext(5).addNext(2);
        ListNode.printNodes(head);
        ListNode.printNodes(new PartitionList().partition(head, 3));
    }
}
