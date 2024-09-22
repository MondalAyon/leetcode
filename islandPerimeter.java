/*
https://leetcode.com/problems/island-perimeter/submissions/1398150298/
https://leetcode.com/problems/island-perimeter/description/
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4

 */
public class islandPerimeter {
    public static void main(String[] args) {
        //int[][]grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][]grid = {{1,0}};

        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int perimeter = 0;

        for (int r=0; r<row; r++) {
            for (int c=0; c<col; c++) {

                // Check if the cell is land.
                if (grid[r][c] == 1) {

                    // Determine the contribution in perimeter by the cell==1
                    // Initializing all side's contribution.

                    int left = 0;   //grid[r][c-1];
                    int right = 0;  //grid[r][c+1];
                    int top = 0;    //grid[r-1][c];
                    int bottom = 0; //grid[r+1][c];

                    //Below section is to determine the contribution in perimeter by each side.
                    //If surroundded by land (i.e. grid[r][c]==1) then perimeter contribution is 0, else 1.
                    //Also taking care of the boundary conditions. If boundary (that means water) then perimeter conitribution = 1.

                    // left side perimeter.
                    if (c == 0)
                        left = 1;
                    else if (grid[r][c-1] == 1)
                        left = 0;
                    else left = 1;

                    // right side perimeter.
                    if (c == col-1)
                        right = 1;
                    else if (grid[r][c+1] == 1)
                        right = 0;
                    else right = 1;

                    // top side perimeter.
                    if (r == 0)
                        top = 1;
                    else if (grid[r-1][c] == 1)
                        top = 0;
                    else top = 1;

                    //bottom side perimeter.
                    if (r == row-1)
                        bottom = 1;
                    else if (grid[r+1][c] == 1)
                        bottom = 0;
                    else bottom = 1;

                    perimeter += left + right + top + bottom;
                }
            }
        }

        return perimeter;
    }


}
