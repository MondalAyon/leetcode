/*
https://leetcode.com/problems/guess-number-higher-or-lower/submissions/1396965934/
https://leetcode.com/problems/guess-number-higher-or-lower/description/

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.

Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1
 */
public class GuessGame {
    private int pick;

    GuessGame(int n) {
        this.pick = n;
    }
    public static int guess(int num) {
        GuessGame obj = new GuessGame(6);
        int result = Integer.MIN_VALUE;

        if (num > obj.pick) result = -1;
        else if (num < obj.pick) result = 1;
        else if (num == obj.pick)  result = 0;

        return result;
    }

    public static void main(String[] args) {
        int n = 10;

        int i = 1;
        int j = n;
        int m = 0;
        int result = -1;

        while (i<=j) {

            m= i+ (j-i) / 2;

            if (guess(m) == 1) {
                i = m + 1;
            } else if (guess(m) == -1) {
                j = m - 1;
            } else if (guess(m) == 0) {
                result = m;
                break;
            }

        }

        System.out.println(result);
    }
}
