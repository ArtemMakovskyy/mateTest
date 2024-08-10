package live.coding.binary.tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import live.coding.binary.tree.TreeNode;

public class Solution94 {
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addInteger(list, root);
        return list;
    }

    private void addInteger(List<Integer> list, TreeNode root) {
        if (root == null) return;
        addInteger(list, root.left);
        list.add(root.val);
        addInteger(list, root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);

            current = current.right;
        }
        return result;
    }
}
