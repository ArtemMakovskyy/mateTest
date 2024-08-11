package live.coding.binary.tree.easy;

import java.util.ArrayList;
import java.util.List;
import live.coding.binary.tree.TreeNode;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addToList(root, list);
        return list;
    }

    private void addToList(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null) addToList(root.left, list);
        if (root.right != null) addToList(root.right, list);
        list.add(root.val);
    }
}
