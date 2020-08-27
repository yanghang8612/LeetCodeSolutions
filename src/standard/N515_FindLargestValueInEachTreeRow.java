package standard;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class N515_FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;
        if (res.size() <= level) res.add(root.val);
        else res.set(level, Math.max(res.get(level), root.val));
        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
    }

    public static void main(String[] args) {

    }
}
