/*
https://leetcode.com/problems/image-smoother/description/

An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother).
If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).
Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.

Example 1:

Input: img = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[0,0,0],[0,0,0],[0,0,0]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0

Example 2:

Input: img = [[100,200,100],[200,50,200],[100,200,100]]
Output: [[137,141,137],[141,138,141],[137,141,137]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 */
public class imageSmoother {

    public static void main(String[] args) {
        int[][] img = {{1,1,1},{1,0,1},{1,1,1}};

        int[][] result = new int[img.length][img[0].length];
        myUtility mu = new myUtility();

        mu.printMatrix(img);
        System.out.println();

        result = imageSmoother(img);
        mu.printMatrix(result);
    }



    public static int[][] imageSmoother(int[][] img) {

        int row = img.length;
        int col = img[0].length;
        int[][] resultImage = new int[row][col];

        int sum = 0;
        int cellCount = 0;

        for (int r=0; r<row; r++) {
            for (int c=0; c<col; c++) {

                sum = 0;
                cellCount = 0;

                for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
                    for (int colOffset = -1; colOffset <= 1; colOffset++) {

                        int nr = r + rowOffset;
                        int nc = c + colOffset;

                        if (nr >= 0 && nc >= 0 && nr <= row - 1 && nc <= col - 1) {
                            sum += img[nr][nc];
                            cellCount++;
                        }
                    }
                }
                resultImage[r][c] = (int) Math.floor(sum / cellCount);
            }
        }
        return resultImage;
    }
}
