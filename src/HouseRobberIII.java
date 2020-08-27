import bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

    public int rob(TreeNode root) {
        return rob(root, new HashMap<>());
    }

    public int rob(TreeNode root, Map<TreeNode, Integer> dp) {
        if (root == null) return 0;
        if (dp.containsKey(root)) return dp.get(root);
        int include = root.val + (root.left == null ? 0 : rob(root.left.left, dp) + rob(root.left.right, dp))
                + (root.right == null ? 0 : rob(root.right.left, dp) + rob(root.right.right, dp));
        int exclude = rob(root.left, dp) + rob(root.right, dp);
        dp.put(root, Math.max(include, exclude));
        return Math.max(include, exclude);
    }

    /**
     * res[0]表示当前node为root但不选的最大值，res[1]表示当前node为root且选的最大值
     * @param root
     * @return
     */
    public int[] rob2(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = rob2(root.left);
        int[] right = rob2(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    public static void main(String[] args) {

    }
}
