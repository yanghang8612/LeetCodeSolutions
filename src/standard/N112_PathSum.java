package standard;

import bean.TreeNode;

public class N112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) return false;
        sum -= root.val;
        if (root.left == root.right && 0 == sum) return true;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {

    }
}
