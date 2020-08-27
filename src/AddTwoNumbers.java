import bean.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1), node = root;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0)
                    + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) node.next = new ListNode(1);
        return root.next;
    }

    public static void main(String[] args) {

    }
}
