package live.coding.binary.tree;

import java.util.List;
import live.coding.binary.tree.easy.Solution101;
import live.coding.binary.tree.easy.Solution104;
import live.coding.binary.tree.easy.Solution112;
import live.coding.binary.tree.easy.Solution226;
import live.coding.binary.tree.easy.Solution94;
import live.coding.binary.tree.medium.Solution114;

public class Start {
    private static final BinaryTreeUtil BINARY_TREE_UTIL = new BinaryTreeUtil();

    public static void main(String[] args) {
//        manipulation114();
//        manipulation94recursion();
//        manipulation94();
//        manipulation101();
//        manipulation104();
//        manipulation112();
        manipulation226();
    }

    private static void manipulation226() {
        Solution226 s = new Solution226();
        BinaryTreeUtil.printTree(BINARY_TREE_UTIL.createBinaryTree226_1());
        TreeNode treeNode_1 = s.invertTree(
                BINARY_TREE_UTIL.createBinaryTree226_1());
        BinaryTreeUtil.printTree(treeNode_1);

//        BinaryTreeUtil.printTree(BINARY_TREE_UTIL.createBinaryTree226_2());
//        TreeNode treeNode_2 = s.invertTree(
//                BINARY_TREE_UTIL.createBinaryTree226_2());
//        BinaryTreeUtil.printTree(treeNode_2);
    }

    private static void manipulation112() {
        Solution112 s = new Solution112();
        System.out.println(s.hasPathSum(
                BINARY_TREE_UTIL.createBinaryTree112_1(),
                22));
        System.out.println(s.hasPathSum(
                BINARY_TREE_UTIL.createBinaryTree112_2(),
                5));
        System.out.println(s.hasPathSum(
                BINARY_TREE_UTIL.createBinaryTree112_3(),
                0));
    }

    private static void manipulation104() {
        final TreeNode root = BINARY_TREE_UTIL.createBinaryTree104();
        BinaryTreeUtil.printTree(root);
        Solution104 s = new Solution104();
        System.out.println(s.maxDepth(root));
    }

    static void manipulation101() {
        TreeNode root1 = BINARY_TREE_UTIL.createBinaryTree101_1();
        TreeNode root2 = BINARY_TREE_UTIL.createBinaryTree101_2();
        Solution101 s101 = new Solution101();
        System.out.println(s101.isSymmetric(root1));
        System.out.println(s101.isSymmetric(root2));

    }

    static void manipulation102() {
        final TreeNode root = BINARY_TREE_UTIL.createBinaryTree94();
        Solution94 s94 = new Solution94();

        final List<Integer> integerList = s94.inorderTraversal(root);
        System.out.println(integerList);
    }

    static void manipulation94() {
        final TreeNode root = BINARY_TREE_UTIL.createBinaryTree94();
        Solution94 s94 = new Solution94();

        final List<Integer> integerList = s94.inorderTraversal(root);
        System.out.println(integerList);

    }

    static void manipulation94recursion() {
        final TreeNode root = BINARY_TREE_UTIL.createBinaryTree94();
        Solution94 s94 = new Solution94();

        final List<Integer> integerList2 = s94.inorderTraversalRecursion(root);
        System.out.println(integerList2);

    }

    static void manipulation114() {
        System.out.println("https://leetcode.com/problems/flatten-binary-tree-to-linked-list/");
        Integer[] values = {1, 2, 5, 3, 4, null, 6};
        TreeNode root = BINARY_TREE_UTIL.createBinaryTreeBase(values);

        System.out.println("Created tree:");
        BINARY_TREE_UTIL.printTree(root);
        System.out.println(">>>>>>>>>>>>>>");

        Solution114 solution = new Solution114();
        solution.flatten(root);

//        System.out.println("New linked list tree:");
//        printTree(root);
//        solution.goByTreeSet(root);
//        printTree(root);
    }
}
