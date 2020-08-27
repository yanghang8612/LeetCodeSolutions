package search;

public class AVLTree<K, V> {

    private class AVLTreeNode<K, V> {
        K key;
        V value;
        int bf;
        AVLTreeNode parent;
        AVLTreeNode left;
        AVLTreeNode right;

        public AVLTreeNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.bf = 0;
        }
    }

    private void rotateLeft(AVLTreeNode node) {
        AVLTreeNode parent = node.parent;
        AVLTreeNode son = node.right;

        son.parent = parent;
        if (parent.left == node)
            parent.left = son;
        else
            parent.right = son;

        node.right = son.left;
        if (son.left != null)
            son.left.parent = node;

        son.left = node;
        node.parent = son;
    }

    public static void main(String[] args) {
        AVLTree<String, String> tree = new AVLTree<>();
    }
}
