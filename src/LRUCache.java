import java.util.*;

public class LRUCache {

    class DLinkNode {
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;

        DLinkNode(){}
        DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private DLinkNode head, tail;

    private int count, capacity;

    private Map<Integer, DLinkNode> cache = new HashMap<>();

    private void addNodeToHead(DLinkNode node) {
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveNodeToHead(DLinkNode node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private DLinkNode popLastNode() {
        DLinkNode node = tail.pre;
        removeNode(tail.pre);
        return node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;

        this.head = new DLinkNode();
        this.tail = new DLinkNode();

        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            moveNodeToHead(cache.get(key));
            return cache.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveNodeToHead(node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(popLastNode().key);
            }
            DLinkNode newNode = new DLinkNode(key, value);
            cache.put(key, newNode);
            addNodeToHead(newNode);
        }
    }

    public static void main(String[] args) {
    }
}
