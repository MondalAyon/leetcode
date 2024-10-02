/* https://leetcode.com/problems/reshape-the-matrix/submissions/1408858862/
https://leetcode.com/problems/reshape-the-matrix/description/

In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:

Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]
Example 2:


Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]
 */

public class matrixReshape {
    public static void main(String[] args) {

        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int r = 4;
        int c = 3;

        System.out.println("Input matrix -");
        print2DArray(mat);

        System.out.println();
        System.out.println("Output matrix -");
        print2DArray(matrixReshape(mat,r,c));

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int R = mat.length;
        int C = mat[0].length;

        if (R*C != r*c) return mat;

        int[][] resultMatrix = new int[r][c];
        int[] tempMatrix = new int[R*C];
        int k = 0;

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                tempMatrix[k] = mat[i][j];
                k++;
            }
        }

        k = 0;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                resultMatrix[i][j] = tempMatrix[k];
                k++;
            }
        }

        return resultMatrix;
    }

    private static void print2DArray(int[][] matrix) {

        for (int i=0; i<matrix.length; i++) {
            System.out.println();
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
