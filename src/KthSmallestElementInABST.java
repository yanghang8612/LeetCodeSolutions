import bean.TreeNode;

public class KthSmallestElementInABST {

    private static class MyNode {
        int val;
        int count;
        MyNode left, right;
        MyNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        MyNode node = build(root);
        return find(node, k);
    }

    private MyNode build(TreeNode root) {
        if (root == null) return null;
        MyNode node = new MyNode(root.val);
        node.left = build(root.left);
        node.right = build(root.right);
        if (node.left != null) node.count += node.left.count;
        if (node.right != null) node.count += node.right.count;
        node.count += 1;
        return node;
    }

    private int find(MyNode root, int k) {
        int leftCount = root.left == null ? 0 : root.left.count;
        if (leftCount == k - 1) return root.val;
        else if (leftCount > k - 1) return find(root.left, k);
        else return find(root.right, k - leftCount - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("[5,3,6,2,4,null,null,1]");
        System.out.println(new KthSmallestElementInABST().kthSmallest(root, 1));
        System.out.println(new KthSmallestElementInABST().kthSmallest(root, 2));
        System.out.println(new KthSmallestElementInABST().kthSmallest(root, 3));
        System.out.println(new KthSmallestElementInABST().kthSmallest(root, 4));
        System.out.println(new KthSmallestElementInABST().kthSmallest(root, 5));
        System.out.println(new KthSmallestElementInABST().kthSmallest(root, 6));
    }
}
