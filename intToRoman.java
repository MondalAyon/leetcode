/*
https://leetcode.com/problems/integer-to-roman/description/
https://leetcode.com/problems/integer-to-roman/submissions/1525984496/

Seven different symbols represent Roman numerals with the following values:

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000
Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:

If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
Given an integer, convert it to a Roman numeral.



Example 1:

Input: num = 3749

Output: "MMMDCCXLIX"

Explanation:

3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 700 = DCC as 500 (D) + 100 (C) + 100 (C)
  40 = XL as 10 (X) less of 50 (L)
   9 = IX as 1 (I) less of 10 (X)
Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
Example 2:

Input: num = 58

Output: "LVIII"

Explanation:

50 = L
 8 = VIII
Example 3:

Input: num = 1994

Output: "MCMXCIV"

Explanation:

1000 = M
 900 = CM
  90 = XC
   4 = IV


Constraints:

1 <= num <= 3999
 */
import java.util.HashMap;

public class intToRoman {

    public static void main(String[] args) {

        // Constraint: 1 <= num <= 3999
        int num = 100;

        System.out.println(intToRoman(num));

    }

    public static String intToRoman(int num) {

        String result = "";
        String numStr = String.valueOf(num);
        numStr = String.format("%4s",numStr).replace(' ','0');
        int l = numStr.length()-1;

        HashMap<Integer, Character> symbolMap = new HashMap<>();
        symbolMap.put(1, 'I');
        symbolMap.put(5, 'V');
        symbolMap.put(10, 'X');
        symbolMap.put(50, 'L');
        symbolMap.put(100, 'C');
        symbolMap.put(500, 'D');
        symbolMap.put(1000, 'M');

        for (int i=0; i<=l; i++) {
            int n = (Integer.valueOf(String.valueOf(numStr.charAt(i)))) * (int) Math.pow(10,l-i);
            //System.out.println(n);

            if (i==0) { /* Thousand's place */
                for (int j=1; j<=num/1000; j++) {
                    result += symbolMap.get(1000);
                }
            }
            else if (i==1) { /* Hundred's place */
                if (n == 400) {
                    result += "CD";
                }
                else if (n == 900) {
                    result += "CM";
                }
                else if (n <= 300) {
                    for (int j=1; j<=n/100; j++) {
                        result += symbolMap.get(100);
                    }
                }
                else if (n >= 500) {
                    result += symbolMap.get(500);
                    int r = (n - 500) / 100;
                    for (int j=1; j<=r; j++) {
                        result += symbolMap.get(100);
                    }
                }
            }

            else if (i==2) { /* Tenth's place */
                if (n == 40) {
                    result += "XL";
                }
                else if (n == 90) {
                    result += "XC";
                }
                else if (n <= 30) {
                    for (int j=1; j<=n/10; j++) {
                        result += symbolMap.get(10);
                    }
                }
                else if (n >= 50 && n <= 80) {
                    result += symbolMap.get(50);
                    int r = (n - 50) / 10;
                    for (int j=1; j<=r; j++) {
                        result += symbolMap.get(10);
                    }

                }
            }

            else if (i==3) { /* One's place */
                if (n==4) {
                    result += "IV";
                }
                else if (n==9) {
                    result += "IX";
                }
                else if (n <= 3) {
                    for (int j=1; j<=n; j++) {
                        result += symbolMap.get(1);
                    }
                }
                else if (n >= 5 && n <= 8) {
                    result += symbolMap.get(5);
                    int r = (n - 5);
                    for (int j=1; j<=r; j++) {
                        result += symbolMap.get(1);
                    }

                }
            }
        }

        return  result;
    }
}
