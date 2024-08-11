package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        // Проверяем, является ли текущий узел корнем поддерева
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Рекурсивно проверяем левое и правое поддеревья
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }

        // Проверяем левое и правое поддеревья
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}