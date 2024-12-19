/* https://leetcode.com/problems/is-subsequence/submissions/1482537176/
https://leetcode.com/problems/is-subsequence/description/

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.


Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class isSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgvbndc";

        System.out.println(isSubsequence(s,t));

    }

    public static boolean isSubsequence(String s, String t) {

        int i = 0;
        int matchCnt = 0;
        int tLen = t.length();

        if (s.length() != 0 && t.length() == 0) return false;

        for (Character c:s.toCharArray()) {

            while (t.charAt(i) != c) {
                i++;
                if (i >= tLen) {
                    return (matchCnt == s.length());
                }
            }

            if (t.charAt(i) == c) {
                i++;
                matchCnt++;

                if (i >= tLen) {
                    break;
                }
            }

            //if (i == tLen - 1) {
            //    return false;
            //}
        }

        return (matchCnt == s.length());
    }
}
