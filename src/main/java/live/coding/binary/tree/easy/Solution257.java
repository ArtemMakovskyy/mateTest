package live.coding.binary.tree.easy;

import java.util.ArrayList;
import java.util.List;
import live.coding.binary.tree.TreeNode;

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            constructPaths(root, "", paths);
        }
        return paths;
    }

    private void constructPaths(TreeNode node, String path, List<String> paths) {
        if (node != null) {
            path += Integer.toString(node.val);
            if (node.left == null && node.right == null) {  // Узел является листом
                paths.add(path);
            } else {
                path += "->";  // Добавляем разделитель перед рекурсивным вызовом
                constructPaths(node.left, path, paths);
                constructPaths(node.right, path, paths);
            }
        }
    }
}