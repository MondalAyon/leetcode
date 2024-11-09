/*
https://leetcode.com/problems/validate-binary-search-tree/submissions/1447241225/
https://leetcode.com/problems/validate-binary-search-tree/description/

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

 */
import java.util.ArrayList;
import java.util.List;

public class isValidBST {
    public static void main(String[] args) {

        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);*/

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        System.out.println(isValidBST(root));


    }

    public static boolean isValidBST(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();

        inOrderTraversal(root, resultList);

        System.out.println(resultList);

        for (int i=0; i<resultList.size()-1; i++) {
            if (resultList.get(i) >= resultList.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public static void inOrderTraversal(TreeNode node, List<Integer> resultList) {

        if (node == null) return;

        inOrderTraversal(node.left, resultList);
        resultList.add(node.val);
        inOrderTraversal(node.right, resultList);

    }
}
