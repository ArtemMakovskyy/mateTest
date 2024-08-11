package live.coding.binary.tree.easy;

import java.util.ArrayList;
import java.util.List;
import live.coding.binary.tree.TreeNode;

public class Solution144 {

    public List<Integer> preorderTraversal_Ok1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addValue_Ok1(root, list);
        return list;
    }

    private void addValue_Ok1(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        addValue_Ok1(root.left, list);
        addValue_Ok1(root.right, list);
    }

    public List<Integer> preorderTraversal_Ok2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        while (node != null) {
            list.add(node.val);
            node = getNextNode_Ok2(node);
        }
        return list;
    }

    private TreeNode getNextNode_Ok2(TreeNode node) {
        if (node.left != null) {
            node = node.left;
        } else if (node.right != null) {
            node = node.right;
        } else {
            node = null;
        }
        return node;
    }
}
