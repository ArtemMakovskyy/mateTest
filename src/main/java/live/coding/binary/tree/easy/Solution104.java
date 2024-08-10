package live.coding.binary.tree.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import live.coding.binary.tree.TreeNode;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        int resault = 0;
        resault = recursionSolution(root);
//        resault = iterateSolution(root);
//        resault = iterateStackSolution(root);
//        resault = iterateSolutionTest(root);
        return resault;
    }

    private int recursionSolution(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int resault = Math.max(leftDepth, rightDepth) + 1;
        return resault;
    }

    private int iterateSolution(TreeNode root) {
        System.out.println();
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // add first
        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            System.out.println("depth " + depth);
            final int size = queue.size();
            System.out.println("queue.size() " + queue.size());
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    System.out.println("currentNode.left.val " + currentNode.left.val);
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    System.out.println("currentNode.right.val " + currentNode.right.val);
                    queue.offer(currentNode.right);
                }
            }
        }
        System.out.println();
        return depth;
    }

    private int iterateSolutionTest(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 0;
    }

    private int iterateStackSolution(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        stack.push(root);
        depths.push(1);
        int maxDepth = 0;

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            int currentDepth = depths.pop();
            maxDepth = Math.max(maxDepth, currentDepth);

            if (currentNode.left != null) {
                stack.push(currentNode.left);
                depths.push(currentDepth + 1);
            }

            if (currentNode.right != null) {
                stack.push(currentNode.right);
                depths.push(currentDepth + 1);
            }
        }

        return maxDepth;
    }
}
