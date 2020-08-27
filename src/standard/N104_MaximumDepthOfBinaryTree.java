package standard;

import bean.TreeNode;

public class N104_MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left),
                right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

    }
}
