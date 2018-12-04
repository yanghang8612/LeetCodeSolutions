import bean.ListNode;

import java.util.Stack;

/**
 * 提交的解法是使用了stack作为辅助
 * 实际上本题需要的是倒序遍历链表
 * 第一步将链表切分成两半，采用一步两步法
 * 第二步将链表后半部分反序
 * 第三步将两个链表合并即可
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        ListNode cur = head, next = cur.next;
        while (cur != next && cur != stack.peek()) {
            cur.next = stack.pop();
            cur.next.next = next;
            cur = next;
            next = cur.next;
        }
        cur.next = null;
    }

    public static void main(String[] args) {

    }
}
