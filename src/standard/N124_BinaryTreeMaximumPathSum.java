package standard;

import bean.TreeNode;

public class N124_BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxToLeafSum(root);
        return max;
    }

    private int maxToLeafSum(TreeNode node) {
        if (null == node) return 0;
        int left = Math.max(0, maxToLeafSum(node.left));
        int right = Math.max(0, maxToLeafSum(node.right));
        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {

    }
}
