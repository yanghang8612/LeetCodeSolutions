import bean.TreeNode;

import java.util.Stack;

public class LowestCommonAncestorOfABinaryTree {

    private Stack<TreeNode> pStack = new Stack<>();
    private Stack<TreeNode> qStack = new Stack<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        trace(new Stack<>(), root, p, q);
        for (int i = 0; i < pStack.size() && i < qStack.size(); i++) {
            if (pStack.get(i).val != qStack.get(i).val) return pStack.get(i - 1);
        }
        return pStack.size() > qStack.size() ? q : p;
    }

    private void trace(Stack<TreeNode> stack, TreeNode root, TreeNode p, TreeNode q) {
        stack.push(root);
        if (!pStack.isEmpty() && !qStack.isEmpty()) return;
        if (root.val == p.val) pStack.addAll(stack);
        if (root.val == q.val) qStack.addAll(stack);
        if (root.left != null) {
            trace(stack, root.left, p, q);
            stack.pop();
        }
        if (root.right != null) {
            trace(stack, root.right, p, q);
            stack.pop();
        }
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor1(root.left, p, q);
        TreeNode r = lowestCommonAncestor1(root.right, p, q);
        return l == null ? r : r == null ? l : root;
    }

    public static void main(String[] args) {
        System.out.println(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(
                TreeNode.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]"), new TreeNode(5), new TreeNode(1)).val);
    }
}
