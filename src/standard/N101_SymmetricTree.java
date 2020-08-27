package standard;

import bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class N101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (null == left || null == right) return left == right;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetricByQueue(TreeNode root) {
        if (null == root) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll(), right = queue.poll();
            if (left == right) continue;
            if (null == left || null == right || left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
