package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        // If the tree is empty, return true
        if (root == null) {
            return true;
        }

        // Helper function to check if all nodes have the same value
        return isUnival(root, root.val);
    }

    private boolean isUnival(TreeNode node, int value) {
        // If the node is null, return true (base case)
        if (node == null) {
            return true;
        }

        // Check if the current node's value is equal to the given value
        if (node.val != value) {
            return false;
        }

        // Recursively check left and right subtrees
        return isUnival(node.left, value) && isUnival(node.right, value);
    }
}