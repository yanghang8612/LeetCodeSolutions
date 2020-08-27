package standard;

import bean.TreeNode;

import java.util.*;

public class N145_BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                res.add(0, cur.val);
                cur = cur.right;
            } else {
                TreeNode node = stack.pop();
                cur = node.left;
            }
        }
        return res;
    }

    public List<Integer> postorderTraversalEasy(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                res.add(0, cur.val);
                stack.push(cur.left);
                stack.push(cur.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
