package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Левое поддерево не сбалансировано
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Правое поддерево не сбалансировано
        }

        // Если разница в высоте между левым и правым поддеревьями больше 1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Дерево не сбалансировано
        }

        // Возвращаем высоту текущего узла
        return Math.max(leftHeight, rightHeight) + 1;
    }
}