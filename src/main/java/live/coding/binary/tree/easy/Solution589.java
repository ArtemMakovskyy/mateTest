package live.coding.binary.tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);

            // Добавляем детей в стек в обратном порядке
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }

        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}