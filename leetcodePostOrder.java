/*
https://leetcode.com/problems/binary-tree-postorder-traversal/description/
Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
*/

import java.util.ArrayList;
import java.util.List;

public class leetcodePostOrder {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);

        //tree = 1;
        tree.left = null;
        tree.right = new TreeNode(2);
        tree.right.right = null;

        tree.right.left = new TreeNode(3);
        tree.right.left.left = null;
        tree.right.left.right = null;

        System.out.print(postorderTraversal(tree));

    }

    private static void postOrder(TreeNode node, List<Integer> resultList) {
        if (node == null) return;
        postOrder(node.left, resultList);
        postOrder(node.right, resultList);
        resultList.add(node.val);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> reslutList = new ArrayList<Integer>();

        postOrder(root, reslutList);

        return reslutList;
    }
}
