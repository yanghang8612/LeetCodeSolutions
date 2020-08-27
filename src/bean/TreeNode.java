package bean;

import java.util.LinkedList;
import java.util.Queue;

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
        System.out.print(node.val + " ");
        printNodesByInOrder(node.right);
    }

    public static void printNodesByPostOrder(TreeNode node) {
        if (node == null)
            return;
        printNodesByPostOrder(node.left);
        printNodesByPostOrder(node.right);
        System.out.print(node.val + " ");
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
