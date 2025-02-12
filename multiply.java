/*
https://leetcode.com/problems/multiply-strings/submissions/1539992398/
https://leetcode.com/problems/multiply-strings/description/

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.



Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"


Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class multiply {
    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "123";


        //System.out.println(stringAdd("9", "1009"));

        System.out.println(multiply(num1, num2));

        //num1 = "912";
        //System.out.println(String.format("%-" + 5 + "s", num1).replace(" ", "0"));

    }

    public static String multiply(String num1, String num2) {
        String result = "0";

        if ("0".equals(num1) || "0".equals(num2)) {
            return result;
        }

        for (int i=num2.length()-1; i>=0; i--) {

            int d1 = Integer.parseInt(String.valueOf(num2.charAt(i)));
            String stepSum = "";
            int carry = 0;

            for (int j=num1.length()-1; j>=0; j--) {

                int d2 = Integer.parseInt(String.valueOf(num1.charAt(j)));
                int s = d1 * d2 + carry;
                stepSum = String.valueOf(s % 10) + stepSum;
                carry = s / 10;
            }

            stepSum = (carry != 0 ? String.valueOf(carry) + stepSum : stepSum);
            stepSum =  String.format("%-" + (stepSum.length() + num2.length()-1 - i) + "s", stepSum).replace(" ", "0");
            result = stringAdd(result, stepSum);

        }

        return result;
    }

    private static String stringAdd(String str1, String str2) {

          int i = str1.length() -1;
          int j = str2.length() -1;
          int carry = 0;
          String sum = "";

          while (i>=0 && j >= 0) {

              int d1 = Integer.parseInt(String.valueOf(str1.charAt(i)));
              int d2 = Integer.parseInt(String.valueOf(str2.charAt(j)));

              int s = d1 + d2 + carry;
              sum = String.valueOf(s % 10) + sum;
              carry = s / 10;

              i--;
              j--;
          }

          while (i < 0 && j >= 0) {
              int d2 = Integer.parseInt(String.valueOf(str2.charAt(j)));
              int s = d2 + carry;
              sum = String.valueOf(s % 10) + sum;
              carry = s / 10;
              j--;
          }

        while (i >=0 && j < 0) {
            int d1 = Integer.parseInt(String.valueOf(str1.charAt(i)));
            int s = d1 + carry;
            sum = String.valueOf(s % 10) + sum;
            carry = s / 10;
            i--;
        }

        sum = (carry != 0 ? String.valueOf(carry) + sum : sum);
        return sum;
    }
}
