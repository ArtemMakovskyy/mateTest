package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // If both trees are null, return null
        if (root1 == null && root2 == null) {
            return null;
        }

        // If one of the trees is null, return the other tree
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // Create a new node with the sum of the values of root1 and root2
        TreeNode mergedNode = new TreeNode(root1.val + root2.val);

        // Recursively merge the left and right subtrees
        mergedNode.left = mergeTrees(root1.left, root2.left);
        mergedNode.right = mergeTrees(root1.right, root2.right);

        return mergedNode;
    }
}