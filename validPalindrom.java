/*
https://leetcode.com/problems/valid-palindrome/submissions/1370659386/
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
*/

public class validPalindrom {
    public static void main(String[] args) {
        //String str = "A man, a plan, a canal: Panama";
        String str = "P";

        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {

        String cleanStr = "";

        for (int i=0; i<s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) || (Character.isDigit(s.charAt(i)))) {
                cleanStr += Character.toLowerCase(s.charAt(i));
            }
        }

        System.out.println("cleanStr = " + cleanStr);

        int i=0;
        int j=cleanStr.length()-1;

        while (i<=j) {
            if (cleanStr.charAt(i) != cleanStr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
