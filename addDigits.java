/*
https://leetcode.com/problems/add-digits/description/
https://leetcode.com/problems/add-digits/submissions/1390364325/

Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.
Example 2:

Input: num = 0
Output: 0
 */

public class addDigits {
    public static void main(String[] args) {
        int num = 2;

        System.out.println(addDigits(num));
    }

    public static int addDigits(int num) {
        String str = String.valueOf(num);
        int sum = 0;

        if (str.length() == 1) return num;

        while (str.length() > 1) {
            sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += Integer.parseInt(str.substring(i, i + 1));
            }
            str = String.valueOf(sum);
        }
        return sum;
    }
}
