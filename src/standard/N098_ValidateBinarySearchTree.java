package standard;

import bean.TreeNode;

/**
 * 因为对于一个平衡二叉树来说，你中序访问他得到的结果必然是整个树包含元素的升序排列
 * 所以在访问过程中，pre节点一定是cur节点在自然排序中的前节点，所以就比较pre节点和
 * cur节点的大小，就能看出来是不是一个正确的BST
 */
public class N098_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (null == root) return true;
        boolean leftValid, rightValid;
        if (null == root.left) {
            leftValid = true;
        } else {
            TreeNode left = root.left;
            while (left.right != null) left = left.right;
            leftValid = root.val > left.val && isValidBST(root.left);
        }
        if (null == root.right) {
            rightValid = true;
        } else {
            TreeNode right = root.right;
            while (right.left != null) right = right.left;
            rightValid = root.val < right.val && isValidBST(root.right);
        }
        return leftValid && rightValid;
    }

    public static void main(String[] args) {

    }
}
