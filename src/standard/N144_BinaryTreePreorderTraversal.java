package standard;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N144_BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return res;
    }

    public List<Integer> preorderTraversalByMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) { // 遭遇左侧为空的节点，因为没有左子树，所以也没有前驱节点，需要输出当前节点
                res.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) { // 寻找职中序序列中当前节点的前驱节点
                    pre = pre.right;
                }
                if (pre.right == null) { // 建立回溯关系
                    res.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                } else { // 当前节点的左子树已经被遍历完毕，那么进入当前节点的右子树
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("[1,2,null]");
        System.out.println(new N144_BinaryTreePreorderTraversal().preorderTraversal(root));
    }

}
