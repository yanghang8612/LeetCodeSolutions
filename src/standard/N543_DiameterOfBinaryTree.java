package standard;

import bean.TreeNode;

public class N543_DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) return 0;
        int curMax = deepest(root.left) + deepest(root.right);
        return Math.max(curMax, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    private int deepest(TreeNode root) {
        if (null == root) return 0;
        return Math.max(deepest(root.left), deepest(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
