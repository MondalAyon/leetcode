/*
https://leetcode.com/problems/magical-string/submissions/1400376491/
https://leetcode.com/problems/magical-string/description/

A magical string s consists of only '1' and '2' and obeys the following rules:

The string s is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string s itself.
The first few elements of s is s = "1221121221221121122……". If we group the consecutive 1's and 2's in s, it will be "1 22 11 2 1 22 1 22 11 2 11 22 ......" and the occurrences of 1's or 2's in each group are "1 2 2 1 1 2 1 2 2 1 2 2 ......". You can see that the occurrence sequence is s itself.

Given an integer n, return the number of 1's in the first n number in the magical string s.

Example 1:

Input: n = 6
Output: 3
Explanation: The first 6 elements of magical string s is "122112" and it contains three 1's, so return 3.
Example 2:

Input: n = 1
Output: 1
 */
public class magicalString {
    public static void main(String[] args) {
        int n = 6;



        System.out.println(magicalString(n));


    }

    public static int magicalString(int n) {

        StringBuilder sb = new StringBuilder("122");
        int ptr = 2;
        int count = 0;

        if (n <= 0) return 0;
        if (n > 0 && n <= 3) return 1;

        while (sb.length() <= n) {
            char toAdd = sb.charAt(sb.length() - 1) == '1' ? '2' : '1';
            int freq = sb.charAt(ptr) - '0';

            for (int i=1; i<=freq; i++) {
                sb.append(toAdd);
            }
            ptr++;
        }

        for (int i=0; i<n; i++) {
            if (sb.charAt(i) == '1')
                count++;
        }

        System.out.println(sb);

        return count;
    }
}
