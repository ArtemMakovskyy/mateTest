package live.coding.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public static Node createTree(Integer[] input) {
        if (input == null || input.length == 0) return null;

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(input[0]);
        queue.add(root);
        int i = 2;

        while (i < input.length) {
            Node parent = queue.poll();
            while (i < input.length && input[i] != null) {
                Node child = new Node(input[i]);
                parent.children.add(child);
                queue.add(child);
                i++;
            }
            i++;
        }

        return root;
    }

    // Метод печати дерева в требуемом формате
    public void printTree() {
        if (this == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                System.out.print(node.val + " ");

                for (Node child : node.children) {
                    queue.add(child);
                }
                size--;
            }
            System.out.print("null\n");
        }
    }
}