package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution543 {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return maxDiameter;
    }

    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Рекурсивно вычисляем глубину левого и правого поддеревьев
        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);

        // Диаметр для текущего узла равен сумме глубин левого и правого поддеревьев
        int currentDiameter = leftDepth + rightDepth;

        // Обновляем максимальный диаметр, если текущий больше
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        // Возвращаем максимальную глубину из двух поддеревьев плюс 1 для текущего узла
        return Math.max(leftDepth, rightDepth) + 1;
    }
}