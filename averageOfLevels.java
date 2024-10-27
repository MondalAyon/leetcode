/*
https://leetcode.com/problems/average-of-levels-in-binary-tree/submissions/1434751950/
https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Example 2:

Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class averageOfLevels {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(averageOfLevels(root));

    }

    /*
    Queue "queue" is used to store nodes from each level.
    Size of the ensures that it reads only one level from the queue.
    FIFO property of queue is used to implement the same.
     */
    public static List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> avgList = new ArrayList<>();

        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {

            Double sum = 0.0;
            Double count = 0.0;

            int l = queue.size(); // This will ensure that the next FOR LOOP reads only that many element as that of the level.

            for (int i=0; i<l; i++) {

                TreeNode node = queue.remove();  // FIFO of the current level
                sum += node.val;
                count++;

                if (node.left != null)      // Next nodes are added to the queue but will not be read in this iteration.
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

            avgList.add(sum/count);
        }
        return avgList;
    }
}
