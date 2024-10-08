/*
https://leetcode.com/problems/number-of-lines-to-write-string/submissions/1415355971/
https://leetcode.com/problems/number-of-lines-to-write-string/description/
You are given a string s of lowercase English letters and an array widths denoting how many pixels wide each lowercase English letter is. Specifically, widths[0] is the width of 'a', widths[1] is the width of 'b', and so on.

You are trying to write s across several lines, where each line is no longer than 100 pixels. Starting at the beginning of s, write as many letters on the first line such that the total width does not exceed 100 pixels. Then, from where you stopped in s, continue writing as many letters as you can on the second line. Continue this process until you have written all of s.

Return an array result of length 2 where:

result[0] is the total number of lines.
result[1] is the width of the last line in pixels.
 
Example 1:

Input: widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10], s = "abcdefghijklmnopqrstuvwxyz"
Output: [3,60]
Explanation: You can write s as follows:
abcdefghij  // 100 pixels wide
klmnopqrst  // 100 pixels wide
uvwxyz      // 60 pixels wide
There are a total of 3 lines, and the last line is 60 pixels wide.
Example 2:

Input: widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10], s = "bbbcccdddaaa"
Output: [2,4]
Explanation: You can write s as follows:
bbbcccdddaa  // 98 pixels wide
a            // 4 pixels wide
There are a total of 2 lines, and the last line is 4 pixels wide.
 */
import java.util.Arrays;

public class numberOfLines {
    public static void main(String[] args) {
        String s = "bbbcccdddaaa";

        //String s = "abc";
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};

        //char a = 'z';
        System.out.println(Arrays.toString(numberOfLines(widths, s)));
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        int lineCount = 0;
        int lineSize = 0;
        int i = 0;

        //for (Character c: s.toCharArray()) {
        //for (int i=0; i<s.length(); i++) {
        while (i < s.length()) {

            lineSize = 0;

            while (lineSize <= 100 && i < s.length()) {
                lineSize += widths[Integer.valueOf(s.charAt(i))-97];
                i++;
            }
            if (lineSize > 100) i--;

            lineCount++;

        }

        result[0] = lineCount;
        result[1] = lineSize;

        return result;
    }
}
