/*
https://leetcode.com/problems/binary-tree-inorder-traversal/description/
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]
 */

import java.util.ArrayList;
import java.util.List;

public class leetcodeInOrder {
    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1);
        tree.left = null;

        tree.right = new TreeNode(2);
        tree.right.right = null;

        tree.right.left = new TreeNode(3);
        tree.right.left.left = null;
        tree.right.left.right = null;

        System.out.println(inorderTraversal(tree));

    }

    private static void inOrder(TreeNode node, List<Integer> resultList) {
        if (node == null) return;
        inOrder(node.left, resultList);
        resultList.add(node.val);
        inOrder(node.right, resultList);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();

        inOrder(root, resultList);

        return resultList;
    }
}
