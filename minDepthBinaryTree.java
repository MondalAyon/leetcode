/* https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.

Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5

 */
public class minDepthBinaryTree {

    public static void main (String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        tree.right.right.left = new TreeNode(10);
        tree.right.right.right = new TreeNode(11);

        System.out.println(minDepth(tree));

    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return traverse(root);
    }

    private static int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = traverse(node.left);
        int right = traverse(node.right);

        if (node.left == null && node.right == null) return 1;

        if (node.left == null && node.right != null) return right+1;
        if (node.right == null && node.left != null) return left+1;

        return Integer.min(left, right) +1;

    }
}
