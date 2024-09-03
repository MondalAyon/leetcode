/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 */
public class maxDepthBinaryTree {
    public static void main (String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        tree.right.right.left = new TreeNode(10);
        tree.right.right.right = new TreeNode(11);

        System.out.println(maxDepth(tree));
        System.out.println((countNodes(tree))-1);

    }


    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int countNodes(TreeNode node) {
        if (node == null) return 1;

        return Integer.sum(countNodes(node.left), countNodes(node.right));
    }
}
