
/* https://leetcode.com/problems/detect-capital/submissions/1401595438/
https://leetcode.com/problems/detect-capital/description/
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
 */
public class detectCapitalUse {
    public static void main(String[] args) {
        String s = "Uss";

        System.out.println(detectCapitalUse(s));
    }

    public static boolean detectCapitalUse(String word) {
        int lowercaseCount = 0;
        int uppercaseCount = 0;

        if (word.length() == 0 || word.equals("") || word.equals(null)) return false;

        for (int i=0; i<word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                lowercaseCount++;
            }
            if (Character.isUpperCase(word.charAt(i))) {
                uppercaseCount++;
            }
        }

        if (lowercaseCount == word.length()) {
            return true;

        } else if (Character.isUpperCase(word.charAt(0)) && lowercaseCount == (word.length()-1)) {
            return true;

        } else if (uppercaseCount == word.length()) {
            return true;
        }

        return false;
    }
}
