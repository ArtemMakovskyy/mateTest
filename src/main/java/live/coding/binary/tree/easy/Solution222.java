package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == rightHeight) {
            // Левое поддерево полностью заполнено
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            // Правое поддерево полностью заполнено
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    private int getHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
}