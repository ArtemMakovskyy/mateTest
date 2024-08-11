package live.coding.binary.tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        Stack<Node> outputStack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            outputStack.push(node);

            // Добавляем детей в стек
            for (Node child : node.children) {
                stack.push(child);
            }
        }

        // Переносим узлы из outputStack в результат
        while (!outputStack.isEmpty()) {
            result.add(outputStack.pop().val);
        }

        return result;
    }
}