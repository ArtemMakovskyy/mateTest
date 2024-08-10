package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Если дерево пустое
        if (root == null) {
            return false;
        }

        // Если узел является листом
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Рекурсивно проверяем левое и правое поддеревья
        int newTargetSum = targetSum - root.val;
        return hasPathSum(root.left, newTargetSum) || hasPathSum(root.right, newTargetSum);
    }
}
