/*
https://leetcode.com/problems/repeated-substring-pattern/description/
https://leetcode.com/problems/repeated-substring-pattern/submissions/
https://leetcode.com/problems/repeated-substring-pattern/solutions/6247012/simple-iterative-solution-beats-97-runti-mib3/

Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.



Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.


Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
 */
public class repeatedSubstringPattern {

    public static void main(String[] args) {
        //String s = "ababab";
        String s = "aba";

        System.out.println(repeatedSubstringPattern(s));

    }

    public static boolean repeatedSubstringPattern(String s) {

        int sLen = s.length();
        boolean result = false;

        for (int l=1; l <= sLen/2; l++) {

            if (sLen % l != 0) {
                continue;
            }

            int j = 0;
            result = true;
            String refString = s.substring(j, j+l);
            j = j + l;

            while (j+l <= sLen) {

                String nextString = s.substring(j, j + l);

                if (!refString.equals(nextString)) {
                    result = false;
                    break;
                }

                j = j + l;
            }

            if (result == true)
                return true;

        }

        return result;
    }
}
