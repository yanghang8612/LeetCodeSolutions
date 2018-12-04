package bean;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) { val = x; }

    public static void printNodesByPreOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        printNodesByPreOrder(node.left);
        printNodesByPreOrder(node.right);
    }

    public static void printNodesByInOrder(TreeNode node) {
        if (node == null)
            return;
        printNodesByInOrder(node.left);
        System.out.println(node.val + " ");
        printNodesByInOrder(node.right);
    }

    public static void printNodesByPostOrder(TreeNode node) {
        if (node == null)
            return;
        printNodesByPostOrder(node.left);
        printNodesByPostOrder(node.right);
        System.out.println(node.val + " ");
    }
}
