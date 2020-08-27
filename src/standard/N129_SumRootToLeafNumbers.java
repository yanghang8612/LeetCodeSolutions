package standard;

import bean.TreeNode;

public class N129_SumRootToLeafNumbers {

    private long sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return root == null ? 0 : (int) sum;
    }

    private void dfs(TreeNode node, long pathSum) {
        if (null == node) return;
        long curSum = pathSum * 10 + node.val;
        if (node.left == node.right) {
            sum += curSum;
        } else {
            dfs(node.left, curSum);
            dfs(node.right, curSum);
        }
    }

    public static void main(String[] args) {

    }
}
