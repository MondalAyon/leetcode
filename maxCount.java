/*
https://leetcode.com/problems/range-addition-ii/description/
https://leetcode.com/problems/range-addition-ii/submissions/1428792287/
https://leetcode.com/problems/range-addition-ii/solutions/5944828/simple-java-o-n/

You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.

Count and return the number of maximum integers in the matrix after performing all the operations.



Example 1:


Input: m = 3, n = 3, ops = [[2,2],[3,3]]
Output: 4
Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.
Example 2:

Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
Output: 4
Example 3:

Input: m = 3, n = 3, ops = []
Output: 9
 */

public class maxCount {
    public static void main(String[] args) {
        int[][] ops = {{2,2},{3,3}};
        int m = 3;
        int n = 3;

        System.out.println(maxCount(m,n,ops));

    }

    public static int maxCount(int m, int n, int[][] ops) {

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        if (ops.length == 0) return m*n;

        for (int r=0; r<ops.length; r++) {
            if (ops[r][0] < minX)
                minX = ops[r][0];
        }

        for (int r=0; r<ops.length; r++) {
            if (ops[r][1] < minY)
                minY = ops[r][1];
        }

        return minX * minY;

    }
}
