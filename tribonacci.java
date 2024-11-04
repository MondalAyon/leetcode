/*
https://leetcode.com/problems/n-th-tribonacci-number/submissions/1443178113/
https://leetcode.com/problems/n-th-tribonacci-number/description/
https://leetcode.com/problems/n-th-tribonacci-number/solutions/6008159/easy-using-dp-with-memoization-beats-100/

The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.



Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
 */
import java.util.HashMap;

public class tribonacci {
    public static void main(String[] args) {
        int n = 25;

        System.out.println(tribonacci(n));

    }

    public static int tribonacci(int n) {

        HashMap<Integer,Integer> memo = new HashMap<>();

        memo.put(0,0);
        memo.put(1,1);
        memo.put(2,1);

        return triboCalc(n, memo);

    }

    private static int triboCalc(int n, HashMap<Integer,Integer> memo) {

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        else {
            int result = triboCalc(n-3, memo) + triboCalc(n-2, memo) + triboCalc(n-1, memo);
            memo.put(n, result);
            return result;
        }
    }

}
