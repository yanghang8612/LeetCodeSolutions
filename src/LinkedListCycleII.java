import bean.ListNode;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        int count = 0, cycle = 0;
        while (slow != null && fast != null && cycle != 2) {
            if (cycle != 0) count += 1;
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if (slow == fast) cycle += 1;
        }
        System.out.println(count);
        if (count != 0) {
            slow = head;fast = head;
            while (count-- != 0) fast = fast.next;
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        String a = "20ms".replaceAll("\\W", "");
        System.out.println(a);
    }
}
