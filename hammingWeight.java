/*
https://leetcode.com/problems/number-of-1-bits/description/ 
Write a function that takes the binary representation of a positive integer and returns the number of
set bits
 it has (also known as the Hamming weight).
 Example 1:

Input: n = 11
Output: 3
Explanation:
The input binary string 1011 has a total of three set bits.

Example 2:

Input: n = 128
Output: 1
Explanation:
The input binary string 10000000 has a total of one set bit.

Example 3:

Input: n = 2147483645
Output: 30
Explanation:
The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
 */

public class hammingWeight {

    public static void main(String[] args) {
        int n = 10;

        System.out.println(hammingWeight(n));

    }

    public static int hammingWeight(int n) {

        String binaryStr = "";

        int q = 0;
        int r = Integer.MIN_VALUE;
        int hw = 0;

        while (r != 0) {
            q = n % 2;
            r = n / 2;

            if (q==1) hw++;
            n = r;
        }
        return hw;
    }
}
