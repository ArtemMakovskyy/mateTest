package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

//Minimum Depth of Binary Tree
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }
}
