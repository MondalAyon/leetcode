/*
https://leetcode.com/problems/ugly-number/description/
An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.

Given an integer n, return true if n is an ugly number.



Example 1:

Input: n = 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: n = 1
Output: true
Explanation: 1 has no prime factors.
Example 3:

Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.


Constraints:

-231 <= n <= 231 - 1
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class isUgly {
    public static void main(String[] args) {

        System.out.println(isUgly(10));

    }

    public static boolean isUgly(int n) {

        boolean isUgly = false;
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);

        if (n <= 0) return false;

        int dividend = n;

        for (Integer i:set) {

            int divisor = i;

            while (dividend % divisor == 0) {
                dividend = dividend / divisor;
            }

            if (dividend == 1) {
                isUgly = true;
                break;
            }
        }

        return isUgly;
    }
}
