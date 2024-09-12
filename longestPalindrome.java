/* https://leetcode.com/problems/longest-palindromic-substring/description/
Submission: https://leetcode.com/problems/longest-palindromic-substring/submissions/1387236028/

Given a string s, return the longest palindromic substring in s.
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:

1 <= s.length <= 1000
 */

public class longestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";

        //System.out.println(isPalindrom(""));
        System.out.println(longestPalindrome(s));
    }

    private static boolean isPalindrom (String s) {
        int strLen = s.length();
        int iMax = 0;
        boolean result = false;

        if (strLen == 0 || s == null || s == "") return false;
        if (strLen == 1) return true;

        if (strLen % 2 == 1) iMax = strLen / 2;
        else iMax = (strLen / 2) - 1;

        int j=strLen-1;
        for (int i=0; i<=iMax; i++) {
            if (s.charAt(i) == s.charAt(j)) {
                result = true;
                j--;
            }
            else return false;
        }
        return result;
    }
    public static String longestPalindrome(String s) {

        int maxLen = 0;
        String resultStr = "";

        int sLen = s.length();

        for (int i=0; i<s.length(); i++) {
            for (int j=sLen-1; j>=0; j--) {
            //for (int j=sLen-1; j >= j - i + 1; j--) {

                if (j - i + 1 < maxLen) {
                    continue;
                }

                if (s.charAt(i) == s.charAt(j)) {

                    String subStr = s.substring(i, j + 1);

                    if (isPalindrom(subStr)) {
                        if (maxLen < subStr.length()) {
                            maxLen = subStr.length();
                            resultStr = subStr;
                        }
                    }
                }
            }
        }

        return resultStr;
    }
}
