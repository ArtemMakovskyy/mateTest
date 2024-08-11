package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution563 {
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        calculateSum(root);
        return totalTilt;
    }

    private int calculateSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = calculateSum(node.left);
        int rightSum = calculateSum(node.right);

        // Наклон текущего узла
        int tilt = Math.abs(leftSum - rightSum);

        // Добавляем наклон к общей сумме
        totalTilt += tilt;

        // Возвращаем сумму значений узлов текущего поддерева
        return leftSum + rightSum + node.val;
    }
}