/*
https://leetcode.com/problems/happy-number/submissions/1372685156/
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
 */

import java.util.ArrayList;
import java.util.List;

public class isHappy {
    public static void main(String[] args) {
        int n = 1;

    System.out.println(isHappy(n));

    }

    public static boolean isHappy(int n) {

        String str = "";
        int sos = 0;
        int d = n;
        List<Integer> sosList = new ArrayList<>();

        while (true) {

            str = Integer.toString(d);

            for (int i = 0; i < str.length(); i++) {
                //System.out.println(str.charAt(i));
                //System.out.println(Integer.parseInt(str.substring(i,i+1)));

                sos += (Integer.parseInt(str.substring(i, i + 1))) * (Integer.parseInt(str.substring(i, i + 1)));
                System.out.println("sos=" + sos);
            }

            if (sos == 1) return true;
            if (sosList.contains(sos)) return false;

            sosList.add(sos);

            d = sos;
            sos = 0;
        }

        //return false;
    }
}
