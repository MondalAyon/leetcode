/*
https://leetcode.com/problems/minimum-absolute-difference-in-bst/
https://leetcode.com/problems/minimum-absolute-difference-in-bst/submissions/

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
Input: root = [4,2,6,1,3]
Output: 1

Input: root = [1,0,48,null,null,12,49]
Output: 1

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class getMinimumDifferenceBST {

    int min = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        getMinimumDifferenceBST obj = new getMinimumDifferenceBST();

        System.out.print(obj.getMinimumDifference(root));

    }

    /* Since the input is a Binary Search Tree, hence the left node(tree) is smaller tham root and right node (tree).
       Hence, if we do InOrder traversal i.e. left -> root -> right, then we get a list of value in increasing order.
     */
    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        if (min > Math.abs(node.val - prev)) {
            min = Math.abs(node.val - prev);
        }
        prev = node.val;

        inOrder(node.right);
    }

    public int getMinimumDifference(TreeNode root) {

        inOrder(root);

        return min;
    }

    /*
    private static void preOrder(TreeNode node, List<Integer> resultList) {

        if (node == null) return;

        resultList.add((node.val));

        preOrder(node.left, resultList);
        preOrder(node.right, resultList);
    }

    public static int getMinimumDifference(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        int diff = 0;

        preOrder(root, resultList);
        Collections.sort(resultList);

        System.out.println(resultList);

        for (int i=0; i<resultList.size()-1; i++) {
            diff = Math.abs(resultList.get(i) - resultList.get(i+1));
            if (diff < minDiff)
                minDiff = diff;
        }

        return minDiff;
    }
     */



}
