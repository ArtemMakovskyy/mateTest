package live.coding.binary.tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import live.coding.binary.tree.BinaryTreeUtil;
import live.coding.binary.tree.TreeNode;

public class Solution637 {

    public static void main(String[] args) {
        Integer[] values1 = {3, 9, 20, null, null, 15, 7};
        final TreeNode bt1 = BinaryTreeUtil.createBinaryTreeBase(values1);
        System.out.println(averageOfLevels(bt1));

        Integer[] values2 = {3, 9, 20, 15, 7};
        final TreeNode bt2 = BinaryTreeUtil.createBinaryTreeBase(values2);
        System.out.println(averageOfLevels(bt2));

        Integer[] values3 = {1};
        final TreeNode bt3 = BinaryTreeUtil.createBinaryTreeBase(values3);
        System.out.println(averageOfLevels(bt3));

        Integer[] values4 = {1, 2, 3, null, 4, 6};
        final TreeNode bt4 = BinaryTreeUtil.createBinaryTreeBase(values4);
        System.out.println(averageOfLevels(bt4));
    }


    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> nodesOnLevel = new LinkedList<>();
        nodesOnLevel.offer(root);

        while (!nodesOnLevel.isEmpty()) {
            double sum = 0;
            final int levelSize = nodesOnLevel.size();
            for (int i = 0; i < levelSize; i++) {
                final TreeNode poll = nodesOnLevel.poll();
                sum += poll.val;
                if (poll.left != null) nodesOnLevel.offer(poll.left);
                if (poll.right != null) nodesOnLevel.offer(poll.right);
            }
            result.add(sum/levelSize);
        }
        return result;
    }
}
