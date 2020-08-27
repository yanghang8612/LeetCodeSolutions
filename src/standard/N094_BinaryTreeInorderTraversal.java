package standard;

import bean.TreeNode;

import java.util.*;

public class N094_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                res.add(node.val);
                p = node.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversalByMorris(TreeNode root) {
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
                    pre.right = cur;
                    cur = cur.left;
                } else { // 当前节点的左子树已经被遍历完毕，那么进入当前节点的右子树
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("[1,2,null,3]");
        System.out.println(new N094_BinaryTreeInorderTraversal().inorderTraversal(root));
    }
}
