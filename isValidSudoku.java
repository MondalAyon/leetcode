/*
https://leetcode.com/problems/valid-sudoku/submissions/1550302264/
https://leetcode.com/problems/valid-sudoku/description/
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


Example 1:


Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
 */
import java.util.HashSet;

public class isValidSudoku {
    public static void main(String[] args) {

        char[][] board = {{'8','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));

    }

    public static boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[r].length; c++) {

                if (board[r][c] != '.') {

                    String rowItem = r + "R" + board[r][c];

                    //check for Rows
                    if (set.contains(rowItem))
                        return false;
                    else set.add(rowItem);

                    String colItem = c + "C" + board[r][c];

                    //check for columns
                    if (set.contains(colItem))
                        return false;
                    else set.add(colItem);

                    //Check for 3x3 squares
                    String squareItem = r / 3 + "-"  + (c / 3) + "S" + board[r][c];
                    if (set.contains(squareItem))
                        return false;
                    else set.add(squareItem);
                }
            }
        }

        return true;
    }
}
