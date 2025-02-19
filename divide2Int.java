/*
https://leetcode.com/problems/divide-two-integers/submissions/1544728778/
https://leetcode.com/problems/divide-two-integers/description/
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.



Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.


Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0
 */
public class divide2Int {
    public static void main (String[] args) {

        int dividend = -1;
        int divisor = 1;

        //System.out.println(divide(dividend, divisor));
        System.out.println(divide3(dividend, divisor));

        /*
        long dividend = 10;
        long divisor = -10;
        long r = 0;
        long q = 0;
        boolean signFlag = false;

        if ((dividend < 0 && divisor > 0) || ((dividend > 0 && divisor < 0) )) {
            signFlag = true;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend == divisor) {
            q = 1;
            q = (signFlag ? (0-q) : q);

        } else {

            //dividend = Math.abs(dividend);
            //divisor = Math.abs(divisor);

            r = dividend - divisor;
            //q++;

            while (r >= divisor) {
                //while (Math.abs(r) >= Math.abs(divisor)) {
                System.out.println("Before: dividend = " + dividend + " divisor = " + divisor + " r = " + r + " q = " + q);

                r = dividend - divisor;
                dividend = r;
                q++;

                System.out.println("After: dividend = " + dividend + " divisor = " + divisor + " r = " + r + " q = " + q);

            }
            q = (int)(signFlag ? (0 - q) : q);
        }

        System.out.println("After loop: r = " + r + " q = " + q);

         */
    }

    public static int divide(int dividend, int divisor) {

        int q = 0;
        int sign = 1;

        if ((dividend < 0 && divisor > 0) || ((dividend > 0 && divisor < 0) )) {
            sign = -1;
        }

        //dividend = Math.abs(dividend);
        //divisor = Math.abs(divisor);

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        /*
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        else if (dividend == -2147483648 && divisor == 1)
         */



        dividend = (dividend < 0 ? -1 * dividend : dividend);
        divisor = (divisor < 0 ? -1 * divisor : divisor);

        if (dividend < divisor) {
            return 0;
        }
        else if (dividend == divisor) {
            return 1 * sign;
        }
        else if (divisor == 1) {
            return dividend * sign;
        }
        else {
            while (dividend > divisor) {
                dividend -= divisor;
                q++;
            }
        }

        return q * sign;
    }

    public static int divide2(int dividend, int divisor) {
        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        /* We need to convert both numbers to negatives
         * for the reasons explained above.
         * Also, we count the number of negatives signs. */
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        /* Count how many times the divisor has to be added
         * to get the dividend. This is the quotient. */
        int quotient = 0;
        while (dividend - divisor <= 0) {
            quotient--;
            dividend -= divisor;
        }

        /* If there was originally one negative sign, then
         * the quotient remains negative. Otherwise, switch
         * it to positive. */
        if (negatives != 1) {
            quotient = -quotient;
        }
        return quotient;
    }


    ////////////////

    public static int divide3(int dividend, int divisor) {

        int negative = 0;
        int q = 0;

        if (dividend == divisor) {
            return 1;
        }

        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }

        if (dividend == 0) {
            return 0;
        }

        if ((divisor == 1 && dividend > 0) || (divisor == 1 && dividend < 0)) {
            return dividend;
        }

        if ((divisor == -1 && dividend < 0) || (divisor == -1 && dividend > 0)) {
            return -1 * dividend;
        }

        if (dividend > 0) {
            dividend = -1 * dividend;
            negative++;
        }
        if (divisor > 0) {
            divisor = -1 * divisor;
            negative++;
        }

        while (dividend - divisor <= 0) {

            dividend -= divisor;
            q++;
        }

        if (negative == 1) {
            q = -1 * q;
        }

        return q;
    }

}
