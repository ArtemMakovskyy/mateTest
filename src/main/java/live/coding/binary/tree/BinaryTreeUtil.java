package live.coding.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtil {

    public TreeNode createBinaryTree226_1() {
        Integer[] values = {4, 2, 7, 1, 3, 6, 9};
        return createBinaryTree114(values);
    }

    public TreeNode createBinaryTree226_2() {
        Integer[] values = {2, 1, 3};
        return createBinaryTree114(values);
    }

    public TreeNode createBinaryTree112_1() {
        Integer[] values = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        return createBinaryTree114(values);
    }
    public TreeNode createBinaryTree112_2() {
        Integer[] values = {1, 2, 3};
        return createBinaryTree114(values);
    }
    public TreeNode createBinaryTree112_3() {
        Integer[] values = {};
        return createBinaryTree114(values);
    }

    public TreeNode createBinaryTree104() {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);

        return root;
    }
    public TreeNode createBinaryTree101_1() {
        // Example 1: [1,2,2,3,4,4,3]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        return root1;
    }

    public TreeNode createBinaryTree101_2() {

        // Example 2: [1,2,2,null,3,null,3]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        return root2;
    }

    public TreeNode createBinaryTree94() {
        // Создание узлов дерева
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.right = node2;
        node2.left = node3;

        printTree(root);
        return root;
    }

    // Метод для создания дерева из массива
    public TreeNode createBinaryTree114(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (index < values.length) {
            TreeNode node = queue.poll();

            if (index < values.length && values[index] != null) {
                node.left = new TreeNode(values[index]);
                queue.add(node.left);
            }
            index++;

            if (index < values.length && values[index] != null) {
                node.right = new TreeNode(values[index]);
                queue.add(node.right);
            }
            index++;
        }

        return root;
    }

    // Метод для визуализации дерева в удобном формате
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println(" Empty tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    System.out.print(node.val + " ");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    System.out.print(" null ");
                }
            }
            System.out.println();
        }
    }
}
