package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution1022 {
    public int sumOfLeafBinaryNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    // Helper function to perform DFS
    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        // Update the current path's binary number
        currentSum = (currentSum << 1) | node.val;

        // If it's a leaf node, return the current binary number
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Recursively compute the sum for left and right subtrees
        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);

        return leftSum + rightSum;
    }
}