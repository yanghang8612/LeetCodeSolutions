import bean.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val) return root;
        if (p.val < root.val && root.val < q.val || q.val < root.val && root.val < p.val)
            return root;
        if (p.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }

    public static void main(String[] args) {

    }
}
