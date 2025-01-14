/*
https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
https://leetcode.com/problems/find-mode-in-binary-search-tree/submissions/1506728145/

Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [1,null,2,2]
Output: [2]
Example 2:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class findMode {
    public static void main(String[] args) {
        //BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(0);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(4);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);



        System.out.println(Arrays.toString(findMode(root)));


    }

    public static int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> mapNodeFreq = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        List<Integer> resultList = new ArrayList<>();

        travers(root, mapNodeFreq);
        System.out.println(mapNodeFreq);

        for (Integer val:mapNodeFreq.values()) {
            maxFreq = (maxFreq < val ? val : maxFreq);
        }

        System.out.println(maxFreq);

        for (Integer key:mapNodeFreq.keySet()) {
            if (mapNodeFreq.get(key) == maxFreq) {
                resultList.add(key);
            }
        }

        System.out.println("List: " + resultList);

        int[] resultArray = new int[resultList.size()];

        for (int i=0; i<resultList.size(); i++)
            resultArray[i] = resultList.get(i);

        return resultArray;
    }

    private static void travers(TreeNode node, HashMap<Integer, Integer> map) {

        if (node == null)
            return;

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        travers(node.left, map);
        travers(node.right, map);
    }



}
