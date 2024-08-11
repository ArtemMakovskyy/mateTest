package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeftLeaves(root, false);
    }

    private int sumLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null && isLeft) {
            return node.val;
        }

        return sumLeftLeaves(node.left, true) + sumLeftLeaves(node.right, false);
    }
}
