package live.coding.binary.tree.easy;


import java.util.List;
import live.coding.binary.tree.Node;

public class Solution559 {

    public static void main(String[] args) {
        Integer[] input1 = {1, null, 3, 2, 4, null, 5, 6};
//        Integer[] input1 = { };
        Node root1 = Node.createTree(input1);
//        System.out.println("Tree 1:");
//        root1.printTree();
        System.out.println("maxDepth:" + maxDepth(root1));

        System.out.println();
//        Integer[] input2 = {1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14};
//        Node root2 = Node.createTree(input2);
//        System.out.println("Tree 2:");
//        root2.printTree();
//        System.out.println("maxDepth: " + maxDepth(root2));
    }


    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int currentDepth = 0;
        final List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            int n = maxDepth(children.get(i));
            if (n > currentDepth) {
                currentDepth = n;
            }
        }
        return currentDepth + 1;
    }


    public static int maxDepth_v1(Node root) {
        if (root == null) {
            return 0;
        }

        int currentDepth = 0;

        List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            Node childNode = children.get(i);
            int childDepth = maxDepth_v1(childNode);
            if (childDepth > currentDepth) {
                currentDepth = childDepth;
            }
        }

        return currentDepth + 1;
    }
}
