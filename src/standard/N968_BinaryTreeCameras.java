package standard;

import bean.TreeNode;

public class N968_BinaryTreeCameras {

    private int res = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) == 0 ? 1 : 0) + res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 2;
        int left = dfs(root.left), right = dfs(root.right);
        if (left == 0 || right == 0) {
            res += 1;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }

    public static void main(String[] args) {

    }
}
