package standard;

import bean.TreeNode;

public class N114_FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (null == root) return;
        if (null != root.left) {
            findRightest(root.left).right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }

    private TreeNode findRightest(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {

    }
}
