package live.coding.binary.tree.easy;

import java.util.LinkedList;
import java.util.Queue;
import live.coding.binary.tree.TreeNode;

public class Solution993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        // Use a queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false, foundY = false;

            // Iterate over the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Check if the current node is x or y
                if (node.val == x) foundX = true;
                if (node.val == y) foundY = true;

                // Add children to the queue
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                // If both x and y are found at the current level, they must have different parents
                if (foundX && foundY) return false;
            }

            // If x and y are found at the same level but not both, they must be cousins
            if (foundX || foundY) return false;
        }

        return true;
    }
}