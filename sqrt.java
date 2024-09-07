/*
https://leetcode.com/problems/sqrtx/description/
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */

public class sqrt {
    public static void main(String[] args) {
        int x = 2147483647;
        //System.out.println(mySqrt(x));
        System.out.println(mySqrtv2(x));
    }

    public static int mySqrt(int x) {

        if (x==0) return 0;
        if (x==1 || x==2) return 1;

        int i=1; //start index
        int j=x; //end index
        int m = 0; //middle



        while (i<=j) {
            m = i + (j-i)/2;

            if (i==j) {
                return i;
            }
            else if ((long)m*(long)m > x) {
                //j = m - 1;
                j = m;

            } else if ((long)m*(long)m < x) {
                //i = m + 1;
                if (i==m) return i;
                i = m;

            } else if ((long)m*(long)m == x) {
                return m;
            }
        }

        return 0;
    }

    public static int mySqrtv2(int x) {
        int i = x/2;
        int result = 0;

        if (x==0) return 0;

        //if (i>46340) i = 46340;

        while (result == 0) {
            if ((long)i*(long)i > x && (long)(i-1)*(long)(i-1) > x) {
                i = i/2;

            } else if ((long)i*(long)i < x && (long)(i+1)*(long)(i+1) < x) {
                i = i+i/2;
            }
            else if ((long)i*(long)i <= x && (long)(i+1)*(long)(i+1) > x) {
                result = i;

            } else if ((long)i*(long)i > x && (long)(i-1)*(long)(i-1) <= x) {
                result = i-1;

            } else if ((long)i*(long)i < x && (long)(i+1)*(long)(i+1) >= x) {
                result = i+1;

            } else if ((long)i*(long)i == x) {
                result = i;
            }
        }
        return result;
    }
}
