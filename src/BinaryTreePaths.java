import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, new StringBuilder(), res);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) return;
        if (root.left == root.right) {
            res.add(sb.toString() + root.val);
        } else {
            int len = String.valueOf(root.val).length() + 2;
            sb.append(root.val).append("->");
            dfs(root.left, sb, res);
            dfs(root.right, sb, res);
            sb.delete(sb.length() - len, sb.length());
        }
    }

    public static void main(String[] args) {

    }
}
