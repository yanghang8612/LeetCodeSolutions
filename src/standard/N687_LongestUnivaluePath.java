package standard;

import bean.TreeNode;

/**
 *
 */
public class N687_LongestUnivaluePath {

    private int len = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (null == root) return 0;
        longestPathDown(root, root.val);
        return len;
    }

    private int longestPathDown(TreeNode root, int val) {
        if (null == root) return 0;
        int left = longestPathDown(root.left, root.val);
        int right = longestPathDown(root.right, root.val);
        len = Math.max(len, left + right);
        if (root.val == val) return 1 + Math.max(left, right);
        return 0;
    }

    public static void main(String[] args) {

    }
}
