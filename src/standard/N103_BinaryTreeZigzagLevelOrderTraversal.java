package standard;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class N103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, 0, res);
        return res;
    }

    private void traversal(TreeNode node, int level, List<List<Integer>> res) {
        if (null == node) return;
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(node.val);
        } else {
            res.get(level).add(0, node.val);
        }
        traversal(node.left, level + 1, res);
        traversal(node.right, level + 1, res);
    }

    public static void main(String[] args) {

    }
}
