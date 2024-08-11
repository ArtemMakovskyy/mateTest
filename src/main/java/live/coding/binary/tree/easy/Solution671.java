package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution671 {
    public int findSecondMinimumValue(TreeNode root) {
        int[] result = new int[2];
        result[0] = root.val;
        result[1] = Integer.MAX_VALUE;
        dfs(root, result);
        return result[1] == Integer.MAX_VALUE ? -1 : result[1];
    }

    private void dfs(TreeNode node, int[] result) {
        if (node == null) return;

        if (node.val > result[0] && node.val < result[1]) {
            result[1] = node.val;
        } else if (node.val == result[0]) {
            dfs(node.left, result);
            dfs(node.right, result);
        }
    }
}