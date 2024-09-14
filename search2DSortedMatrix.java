/*
https://leetcode.com/problems/search-a-2d-matrix/description/
https://leetcode.com/problems/search-a-2d-matrix/submissions/1390089089/

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 */

public class search2DSortedMatrix {
    public static void main(String[] args) {

        int[][] array = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        //int [][] array = {{1},{3}};

        //int[] array = {1,3,5,7,8,9,10};  // for testing the 1-D binary search.
        //System.out.println(searchSortedArray(array, 6));

        //print2dArray(array);
        //System.out.println(searchMatrixV2(array, 35));


        /* Using test cases */
        runTestCases();
    }


    public static boolean searchSortedArray(int[] array, int target) {
        int h = array.length - 1;
        int l = 0;
        boolean found = false;

        while (l <= h) {

            int m = l + (h-l)/2;

            if (target == array[m]) {
                found = true;
                break;
            }
            if (target < array[m]) {
                h = m - 1;
            }
            else l = m + 1;
        }
        return found;
    }

    public static boolean searchMatrixV2(int[][] matrix, int target) {

        int r = matrix.length;
        int c = matrix[0].length;
        boolean found = false;

        if (target < matrix[0][0] || target > matrix[r-1][c-1]) return false;

        for (int i=0; i<r; i++) {

            if (target >= matrix[i][0] && target <= matrix[i][c-1]) {
                //System.out.println("Item may be at array[" + i + "][c]");
                found = searchSortedArray(matrix[i], target);
                return found;
            }

        }

        return found;

    }

    public static void print2dArray(int[][] array) {
        System.out.println();
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void check(int testCaseNo, boolean expected, boolean testOutput) {
        String outcome = "";

        if (expected == testOutput)
            outcome = "Passed";
        else outcome = "Failed";

        System.out.println("TestCase " + testCaseNo + " : " + outcome);
    }

    public static void testCase1 () {
        int[][] inputMatrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int inputTarget = 34;
        boolean expectedOutput = true;

        check(1, expectedOutput, searchMatrixV2(inputMatrix, inputTarget));
    }

    public static void testCase2 () {
        int [][] inputMatrix = {{1},{3}};
        int inputTarget = 3;
        boolean expectedOutput = true;

        check(2, expectedOutput, searchMatrixV2(inputMatrix, inputTarget));
    }
    public static void runTestCases() {
        testCase1();
        testCase2();
    }
}



