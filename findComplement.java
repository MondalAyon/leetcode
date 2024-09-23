/*
https://leetcode.com/problems/number-complement/submissions/1399265035/
https://leetcode.com/problems/number-complement/description/
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.



Example 1:

Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:

Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */


public class findComplement {
    public static void main(String[] args) {
        int num = 5;

        System.out.println(findComplement(num));
    }

    public static int findComplement(int num) {

        String s = Integer.toBinaryString(num);
        String sc = "";

        for (Character c:s.toCharArray()) {
            char complement = (char)((c == '1') ? '0' : '1');
            sc += String.valueOf(complement);
        }

        return Integer.parseInt(sc, 2);
    }
}
