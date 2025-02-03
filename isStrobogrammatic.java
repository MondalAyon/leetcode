/*
https://leetcode.com/problems/strobogrammatic-number/description/
https://leetcode.com/problems/strobogrammatic-number/submissions/1530218722/
https://leetcode.com/problems/strobogrammatic-number/solutions/

Given a string num which represents an integer, return true if num is a strobogrammatic number.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).



Example 1:

Input: num = "69"
Output: true
Example 2:

Input: num = "88"
Output: true
Example 3:

Input: num = "962"
Output: false


Constraints:

1 <= num.length <= 50
num consists of only digits.
num does not contain any leading zeros except for zero itself.

 */

public class isStrobogrammatic {
    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("96"));

    }

    public static boolean isStrobogrammatic(String num) {
        StringBuilder num180Rotated = new StringBuilder();

        for (int i=num.length()-1; i>=0; i--) {

            if (num.charAt(i) != '0' && num.charAt(i) != '1' && num.charAt(i) != '6' && num.charAt(i) != '9' && num.charAt(i) != '8')
                return false;
            else if (num.charAt(i) == '6')
                num180Rotated.append('9');
            else if (num.charAt(i) == '9')
                num180Rotated.append('6');
            else
                num180Rotated.append(num.charAt(i));
        }

        return num.equals(num180Rotated.toString());
    }


}
