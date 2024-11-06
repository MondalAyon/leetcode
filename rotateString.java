/* https://leetcode.com/problems/rotate-string/description/

https://leetcode.com/problems/rotate-string/submissions/1444333663/

Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.


Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 */


/* Best solution: s = s + s; then check if goal is in s.
 */

public class rotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";

        System.out.println(rotateString(s,goal));

    }

    public static boolean rotateString(String s, String goal) {

        StringBuilder sb = new StringBuilder();

        if (s.length() != goal.length()) return false;

        for (int counter = 0; counter<s.length(); counter++) {

            for (int i = 1; i < s.length(); i++) {
                sb.append(s.charAt(i));
            }
            sb.append(s.charAt(0));

            if (sb.toString().equals(goal)) {
                return true;
            }
            s = sb.toString();
            sb.delete(0,sb.length());

        }
        return false;
    }
}
