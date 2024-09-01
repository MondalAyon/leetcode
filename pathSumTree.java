/*
https://leetcode.com/problems/path-sum/description/
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the
values along the path equals targetSum.
A leaf is a node with no children.

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
 */
public class pathSumTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(8);

        tree.left.left = new TreeNode(11);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);

        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);
        tree.right.right.right = new TreeNode(1);

        int targetSum = 181;

        System.out.println(hasPathSum(tree, targetSum));

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return (hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val));
    }
}
