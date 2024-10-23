/*

https://leetcode.com/problems/valid-palindrome-ii/description/
https://leetcode.com/problems/valid-palindrome-ii/submissions/1431123771/

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 */
public class validPalindrome {
    public static void main(String[] args) {
        //String s = "eeccccbebaeeabebccceea";
        String s = "ebcbbececabbacecbbcbe";

        //String s = "becebbecb";

        System.out.println(validPalindromeV2(s));
    }

    public static boolean validPalindromeV2(String s) {

        int i = 0;
        int j = s.length()-1;
        boolean firstMismatch = true;

        boolean rightRemoveCheck = true;
        boolean leftRemoveCheck = true;

        while (i<j) {

            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }

            if (s.charAt(i) != s.charAt(j) && firstMismatch) {

                firstMismatch = false;
                j--;
            }
            else if (s.charAt(i) != s.charAt(j) && !firstMismatch) {
                rightRemoveCheck = false;
                break;
            }
        }


        i = 0;
        j = s.length()-1;
        firstMismatch = true;

        while (i<j) {

            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }

            if (s.charAt(i) != s.charAt(j) && firstMismatch) {

                firstMismatch = false;
                i++;
            }
            else if (s.charAt(i) != s.charAt(j) && !firstMismatch) {
                leftRemoveCheck = false;
                break;
            }
        }

        return rightRemoveCheck || leftRemoveCheck;
    }

    public static boolean validPalindrome(String s) {

        int i = 0;
        int j = s.length()-1;
        boolean firstMismatch = true;

        while (i<j) {

            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }

            if (s.charAt(i) != s.charAt(j) && firstMismatch) {

                firstMismatch = false;

                if (s.charAt(i) == s.charAt(j-1)) {
                    j--;

                } else if (s.charAt(i+1) == s.charAt(j)) {
                    i++;
                }
                else {
                    return false;
                }
            }
            else if (s.charAt(i) != s.charAt(j) && !firstMismatch) {
                return false;
            }
        }

        return true;
    }
}
