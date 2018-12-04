import bean.ListNode;
import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 最骚的是一个LinkedList里的中点可以用步进法，一个fast指针一个slow指针，fast指针比slow指针慢一步
 */
public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int[] list = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            list[i] = nums.get(i);
        }
        return sortedListToBST(list, 0, list.length - 1);
    }

    private TreeNode sortedListToBST(int[] list, int start, int end) {
        if (start > end) return null;
        int mid = (int) Math.ceil(((double) start + end) / 2);
        TreeNode node = new TreeNode(list[mid]);
        node.left = sortedListToBST(list, start, mid -1);
        node.right = sortedListToBST(list, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.addNext(-3).addNext(0).addNext(5).addNext(9);
        TreeNode.printNodesByInOrder(new ConvertSortedListToBinarySearchTree().sortedListToBST(head));
    }
}
