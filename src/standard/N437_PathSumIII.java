package standard;

import bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 这题如果用纯遍历的递归做的话注意
 * 原想法里四个递归写在一起，但这样会导致重复计算
 * 因此应该将路径从当前位置开始的递归单独拎出来做
 * 而不应该放在一起
 * 另外哈希的解法理解的关键在于计算解并不是直接root.val+cur==sum
 * 关键在于理解cur-sum，map存储的是所有以root为根的path的sum值
 * 而非当前node之前所有有效path的sum值，这样做的好处在于遍历一个节点时
 * 我们只需要更新map中的某一项，其余项不需要更新
 * 如果采用后面的记录方式，那么每遍历一个节点，记录表中的所有项均需要加上当前节点的val
 */
public class N437_PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return pathSum(root, 0, sum, preSum);
    }

    public int pathSum(TreeNode root, int cur, int sum, Map<Integer, Integer> preSum) {
        if (null == root) return 0;
        cur += root.val;
        int cnt = preSum.getOrDefault(cur - sum, 0);
        preSum.put(cur, preSum.getOrDefault(cur, 0) + 1);
        cnt += pathSum(root.left, cur, sum, preSum) + pathSum(root.right, cur, sum, preSum);
        preSum.put(cur, preSum.get(cur) - 1);
        return cnt;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("[1,null,2,null,3,null,4,null,5]");
        System.out.println(new N437_PathSumIII().pathSum(root, 3));
    }
}
