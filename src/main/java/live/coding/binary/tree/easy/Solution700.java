package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution700 {

    public TreeNode searchBST(TreeNode root, int val) {
        // Base case: if the root is null or the root's value matches the target value
        if (root == null || root.val == val) {
            return root;
        }

        // If the target value is less than the current node's value, search in the left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // If the target value is greater than the current node's value, search in the right subtree
        return searchBST(root.right, val);
    }
}