package standard;

import bean.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class N023_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> q = new PriorityQueue<>(lists.length,
                Comparator.comparingInt(n -> n.val));
        for (ListNode node : lists)
            if (node != null)
                q.offer(node);
        ListNode dummy = new ListNode(0), node = dummy;
        while (!q.isEmpty()) {
            node.next = q.poll();
            node = node.next;
            if (node.next != null)
                q.offer(node.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
