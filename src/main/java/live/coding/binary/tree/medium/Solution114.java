package live.coding.binary.tree.medium;

import live.coding.binary.tree.TreeNode;

public class Solution114 {
    private TreeNode last = null; // Переменная для отслеживания последнего обработанного узла

    public void goByTreeSet(TreeNode node) {
        if (node == null) return;
//        System.out.println("this node: " + node.val +
//                ",<< -- left node: " + (node.left != null ? node.left.val : -1) +
//                ",-- >> right node: " + (node.right != null ? node.right.val : -1));
        goByTreeSet(node.left);
        goByTreeSet(node.right);

    }

    public void flatten(TreeNode root) {
        System.out.println(root != null ? root.val : -1);

        // Базовый случай: если узел равен null, ничего не делаем
        if (root == null) return;

        // Сначала рекурсивно выравниваем правое поддерево
        // Это необходимо для того, чтобы преобразовать правое поддерево в связный список
        // В результате правое поддерево будет преобразовано в связный список
        flatten(root.right);

        // Затем рекурсивно выравниваем левое поддерево
        // После выравнивания правого поддерева, левое поддерево также преобразуется в связный список
        // Важно сначала выравнить правое поддерево, чтобы связный список был правильно собран
        flatten(root.left);

        // После того как правое и левое поддеревья выровнены:
        // 1. Устанавливаем правый указатель текущего узла на последний обработанный узел (last)
        // Это обеспечивает правильное соединение узлов в порядке обхода
        root.right = last;

        // 2. Устанавливаем левый указатель текущего узла на null
        // Поскольку мы выравниваем дерево в связный список, левый указатель должен быть равен null
        root.left = null;

        // 3. Обновляем последний обработанный узел (last) на текущий узел
        // Это позволяет нам корректно связывать узлы в следующем шаге
        last = root;
    }
}
