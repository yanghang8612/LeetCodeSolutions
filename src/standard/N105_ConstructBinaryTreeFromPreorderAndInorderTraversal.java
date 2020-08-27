package standard;

import bean.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class N105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, 0, preorder.length, map);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int inStart, int len, Map<Integer, Integer> map) {
        if (len == 0) return null;
        TreeNode first = new TreeNode(preorder[preStart]);
        if (len != 1) {
            int i = map.get(first.val) - inStart;
            first.left = buildTree(preorder, preStart + 1, inStart, i, map);
            first.right = buildTree(preorder, preStart + i + 1, inStart + i + 1, len - i - 1, map);
        }
        return first;
    }

    public TreeNode buildTreeByStack(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            int value = preorder[i];
            TreeNode node = new TreeNode(value);
            if (map.get(value) < map.get(stack.peek().val)) {
                stack.peek().left = node;
            } else {
                TreeNode parent = null;
                while (!stack.isEmpty() && map.get(value) > map.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode.printNodesByInOrder(new N105_ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(
                new int[]{}, new int[]{}
        ));
    }
}
