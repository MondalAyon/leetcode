/*
https://leetcode.com/problems/binary-tree-preorder-traversal/description/
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [1,2,3]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
*/


import java.util.ArrayList;
import java.util.List;

public class leetcodePreOrder {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);

        //tree = 1;
        tree.left = null;
        tree.right = new TreeNode(2);
        tree.right.right = null;

        tree.right.left = new TreeNode(3);
        tree.right.left.left = null;
        tree.right.left.right = null;

        System.out.print(preorderTraversal(tree));

    }

    private static void preOrder(TreeNode node, List<Integer> resultList) {
        if (node == null) return;
        resultList.add(node.val);
        preOrder(node.left, resultList);
        preOrder(node.right, resultList);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> reslutList = new ArrayList<Integer>();

        preOrder(root, reslutList);

        return reslutList;
    }
}
