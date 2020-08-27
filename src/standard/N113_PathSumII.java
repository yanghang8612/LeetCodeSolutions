package standard;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class N113_PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (null == root) return;
        sum -= root.val;
        if (root.left == root.right && 0 == sum) {
            List<Integer> tmp = new ArrayList<>(path);
            tmp.add(root.val);
            res.add(tmp);
        }
        path.add(root.val);
        dfs(root.left, sum, path, res);
        dfs(root.right, sum, path, res);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

    }
}
