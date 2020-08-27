package standard;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class N107_BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(res, root, 1);
        return res;
    }

    private void traversal(List<List<Integer>> res, TreeNode root, int level) {
        if (null == root) return;
        if (res.size() < level) {
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - level).add(root.val);
        traversal(res, root.left, level + 1);
        traversal(res, root.right, level + 1);
    }

    public static void main(String[] args) {

    }
}
