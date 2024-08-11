package live.coding.binary.tree.easy;

import live.coding.binary.tree.TreeNode;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // Выбор среднего элемента для корня
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(mid);

        // Рекурсивное создание левого и правого поддеревьев
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);

        return node;
    }
}