import bean.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head, cloneNode = new RandomListNode(0);
        while (node != null) {
            cloneNode.next = new RandomListNode(node.label);
            cloneNode = cloneNode.next;
            map.put(node, cloneNode);
            node = node.next;
        }
        node = head;
        cloneNode = map.get(head);
        while (node != null) {
            cloneNode.random = map.get(node.random);
            node = node.next;
            cloneNode = cloneNode.next;
        }
        return map.get(head);
    }

    public RandomListNode copyRandomList_Way2(RandomListNode head) {
        RandomListNode node = head, next;
        while (node != null) {
            next = node.next;
            node.next = new RandomListNode(node.label);
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
        RandomListNode copy, cloneHead = head == null ? null : head.next;
        node = head;
        while (node != null) {
            copy = node.next;
            node.next = node.next.next;
            node = node.next;
            if (node != null) {
                copy.next = copy.next.next;
            }
        }
        return cloneHead;
    }

    public static void main(String[] args) {

    }
}
