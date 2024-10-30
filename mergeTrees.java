/*
https://leetcode.com/problems/merge-two-binary-trees/description/
https://leetcode.com/problems/merge-two-binary-trees/submissions/1437722093/

You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.

 

Example 1:


Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]
Example 2:

Input: root1 = [1], root2 = [1,2]
Output: [2,2]

 */
public class mergeTrees {
    public static void main(String[] args) {

        myUtility mu = new myUtility();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);

        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        mu.printBTreePreorder(mergeTreesV2(root1, root2));



    }

    public static TreeNode mergeTreesV2(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 != null && root2 == null) {
            return root1;
        }

        if (root1 == null && root2 != null) {
            return root2;
        }

        TreeNode node = new TreeNode();

        node.val = root1.val + root2.val;

        node.left = mergeTreesV2(root1.left, root2.left);
        node.right = mergeTreesV2(root1.right, root2.right);

        return node;

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        merge(root1, root2);
        return root1;
    }

    public static TreeNode merge(TreeNode node1, TreeNode node2) {

        System.out.println("Node1: " + node1.val + " Node2: " + node2.val);

        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 != null && node2 != null) {
            node1.val += node2.val;
            return node1;
        }
        if (node1 != null && node2 == null) {
            return node1;
        }

        if (node1 == null && node2 != null) {
            node1 = new TreeNode();
            node1.val = node2.val;
            return node1;
        }

        node1.left = merge(node1.left, node2.left);
        node1.right = merge(node1.right, node2.right);

        return node1;
    }
}
