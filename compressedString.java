/*
https://leetcode.com/problems/string-compression-iii/description/?envType=daily-question&envId=2024-11-28
https://leetcode.com/problems/string-compression-iii/submissions/1464907639/?envType=daily-question&envId=2024-11-28

Given a string word, compress it using the following algorithm:

Begin with an empty string comp. While word is not empty, use the following operation:
Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
Append the length of the prefix followed by c to comp.
Return the string comp.

 

Example 1:

Input: word = "abcde"

Output: "1a1b1c1d1e"

Explanation:

Initially, comp = "". Apply the operation 5 times, choosing "a", "b", "c", "d", and "e" as the prefix in each operation.

For each prefix, append "1" followed by the character to comp.

Example 2:

Input: word = "aaaaaaaaaaaaaabb"

Output: "9a5a2b"

Explanation:

Initially, comp = "". Apply the operation 3 times, choosing "aaaaaaaaa", "aaaaa", and "bb" as the prefix in each operation.

For prefix "aaaaaaaaa", append "9" followed by "a" to comp.
For prefix "aaaaa", append "5" followed by "a" to comp.
For prefix "bb", append "2" followed by "b" to comp.
 

Constraints:

1 <= word.length <= 2 * 105
word consists only of lowercase English letters.
 */
public class compressedString {
    public static void main(String[] args) {
        String word = "aaaaaaaaay";

        System.out.println(compressedStringV2(word));

    }

    /* using SB runs in 44ms in leetcode: https://leetcode.com/problems/string-compression-iii/submissions/1464907639/?envType=daily-question&envId=2024-11-28
    * without SB, took > 1K ms */
    public static String compressedStringV2(String word) {

        StringBuilder sb = new StringBuilder();
        int count = 1;

        if (word.length() == 1) {
            return "1" + word;
        }

        for (int i = 1; i<word.length(); i++) {
            if (word.charAt(i-1) == word.charAt(i)) {
                count++;

                if (count == 9) {
                    sb.append("9" + word.charAt(i));
                    count = 0;
                }
            }
            else {
                if (count > 0) {
                    sb.append(String.valueOf(count) + word.charAt(i - 1));
                }
                count = 1;
            }
        }

        if (count > 0) {
            sb.append(String.valueOf(count) + word.charAt(word.length()-1));
        }

        return sb.toString();
    }

    public static String compressedString(String word) {

        String resultStr = "";
        int count = 1;

        if (word.length() == 1) {
            return "1" + word;
        }

        for (int i = 1; i<word.length(); i++) {
            if (word.charAt(i-1) == word.charAt(i)) {
                count++;

                if (count == 9) {
                    resultStr += "9" + word.charAt(i);
                    count = 0;
                }
            }
            else {
                if (count > 0) {
                    resultStr += String.valueOf(count) + word.charAt(i - 1);
                }
                count = 1;
            }
        }

        if (count > 0) {
            resultStr += String.valueOf(count) + word.charAt(word.length()-1);
        }

        return resultStr;
    }
}
