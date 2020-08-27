package standard;

import bean.TreeNode;

public class N993_CousinsInBinaryTree {

    private int xDepth, yDepth, xParent, yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, 0);
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfs(TreeNode root, int x, int y, int depth, int parent) {
        if (root == null) return;
        if (root.val == x) {
            xDepth = depth;
            xParent = parent;
        } else if (root.val == y) {
            yDepth = depth;
            yParent = parent;
        } else {
            dfs(root.left, x, y, depth + 1, root.val);
            dfs(root.right, x, y, depth + 1, root.val);
        }
    }

    public static void main(String[] args) {

    }
}
