/*
https://leetcode.com/problems/flip-game/description/
https://leetcode.com/problems/flip-game/submissions/1534290970/
https://leetcode.com/problems/flip-game/solutions/6387478/simple-solution-beat-100-on-runtime-by-a-zl21/
You are playing a Flip Game with your friend.

You are given a string currentState that contains only '+' and '-'. You and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move, and therefore the other person will be the winner.

Return all possible states of the string currentState after one valid move. You may return the answer in any order. If there is no valid move, return an empty list [].



Example 1:

Input: currentState = "++++"
Output: ["--++","+--+","++--"]
Example 2:

Input: currentState = "+"
Output: []


Constraints:

1 <= currentState.length <= 500
currentState[i] is either '+' or '-'.
 */
import java.util.ArrayList;
import java.util.List;

public class generatePossibleNextMoves {
    public static void main(String[] args) {
        String currentState = "+";

        System.out.println(generatePossibleNextMoves(currentState));
    }

    public static List<String> generatePossibleNextMoves(String currentState) {

        List<String> result = new ArrayList<>();

        for (int i=0; i<currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i+1) == '+') {

                char[] t = new char[currentState.length()];
                t = currentState.toCharArray();
                t[i] = '-';
                t[i+1] = '-';
                String tStr = new String(t);
                result.add(tStr);
            }
        }

        return result;
    }
}
