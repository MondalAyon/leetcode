/*
https://leetcode.com/problems/excel-sheet-column-number/description/
Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
*/

public class titleToNumber {
    public static void main(String[] args) {
        String str = "FXSHRXW";

        System.out.println(titleToNumber(str));

    }

    public static int titleToNumber(String columnTitle) {
        int colIndex = 0;
        char alpha;
        int resultNumber = 0;
        int aV;

        for (int i=0; i<columnTitle.length(); i++) {
            colIndex = columnTitle.length()-(i+1);
            alpha = columnTitle.charAt(i);
            aV = ((int)alpha - 64);

            resultNumber+= ((int)Math.pow(26,colIndex)) * aV;
        }
        return resultNumber;
    }


}
