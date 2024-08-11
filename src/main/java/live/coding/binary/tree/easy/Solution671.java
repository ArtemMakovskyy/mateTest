package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution671 {
    public int findSecondMinimumValue(TreeNode root) {
        // Initialize the smallest and second smallest values
        int[] result = new int[2]; // result[0] will be smallest, result[1] will be second smallest
        result[0] = root.val;
        result[1] = Integer.MAX_VALUE;

        dfs(root, result);

        // If result[1] is still Integer.MAX_VALUE, return -1
        return result[1] == Integer.MAX_VALUE ? -1 : result[1];
    }

    private void dfs(TreeNode node, int[] result) {
        if (node == null) return;

        // Check the node value
        if (node.val > result[0] && node.val < result[1]) {
            result[1] = node.val;
        } else if (node.val == result[0]) {
            // Continue to check the children if the node value is equal to the smallest value
            dfs(node.left, result);
            dfs(node.right, result);
        }
    }
}