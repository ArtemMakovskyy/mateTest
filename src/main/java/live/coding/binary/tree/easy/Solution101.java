package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMatch(root.left, root.right);
    }

    private boolean isMatch(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return (left.val == right.val)
                && isMatch2(left.left, right.right)
                && isMatch2(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return isMatch(root.left, root.right);
    }

    private boolean isMatch2(TreeNode left, TreeNode right) {
        // Если оба поддерева пустые, они симметричны
        if (left == null && right == null) return true;
        // Если одно из поддеревьев пустое, а другое нет, дерево не симметрично
        if (left == null || right == null) return false;

        // Проверяем три условия:
        // 1. Значения текущих узлов должны быть равны
        // 2. Левый потомок левого поддерева должен быть симметричен правому потомку правого поддерева
        // 3. Правый потомок левого поддерева должен быть симметричен левому потомку правого поддерева
        return (left.val == right.val)
                && isMatch2(left.left, right.right)
                && isMatch2(left.right, right.left);
    }
}
