package live.coding.binary.tree.easy;

import java.util.Stack;
import live.coding.binary.tree.TreeNode;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
//         root = iterateSample(root);
         root = recursiveSample(root);
         return root;
    }
    private TreeNode recursiveSample(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Рекурсивно инвертируем поддеревья
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // Меняем местами левое и правое поддеревья
        root.left = right;
        root.right = left;

        return root;
    }

    private TreeNode iterateSample(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();

            // Меняем местами левое и правое поддеревья
            TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;

            // Добавляем узлы в стек для дальнейшей обработки
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }
        return root;
    }
}
