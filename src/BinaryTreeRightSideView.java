import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> left = rightSideView(root.left);
        List<Integer> right = rightSideView(root.right);
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        res.addAll(right);
        if (left.size() > right.size()) res.addAll(left.subList(right.size(), left.size()));
        return res;
    }

    /**
     * 自己的方法里产生了太多的临时list，这是没有必要的
     * 一般二叉树的遍历过程需要解决一些问题，那么可以在函数的形参上做文章，将临时存储用的对象放入，而不是一定要采用函数返回的方式
     * 此外这个题中就是在每一层的遍历中选一个node作为该层的可视node，那么我们按照先访问右侧再访问左侧的方式时，每一层第一次访问
     * 时就肯定是可视元素，因为该元素在该层的最右边
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideView2(root, res, 0);
        return res;
    }

    public void rightSideView2(TreeNode root, List<Integer> res, int curDepth) {
        if (root != null) {
            if (curDepth == res.size()) res.add(root.val);
            rightSideView2(root.right, res, curDepth + 1);
            rightSideView2(root.left, res, curDepth + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("[1,null,2,null,5,4,6,3]");
        new BinaryTreeRightSideView().rightSideView(root);
    }
}
