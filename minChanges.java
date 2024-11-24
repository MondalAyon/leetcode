/*
https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/solutions/6077533/simple-solution-o-n/
https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/submissions/1461399387/
https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/description/
You are given two positive integers n and k.

You can choose any bit in the binary representation of n that is equal to 1 and change it to 0.

Return the number of changes needed to make n equal to k. If it is impossible, return -1.

 

Example 1:

Input: n = 13, k = 4

Output: 2

Explanation:
Initially, the binary representations of n and k are n = (1101)2 and k = (0100)2.
We can change the first and fourth bits of n. The resulting integer is n = (0100)2 = k.

Example 2:

Input: n = 21, k = 21

Output: 0

Explanation:
n and k are already equal, so no changes are needed.

Example 3:

Input: n = 14, k = 13

Output: -1

Explanation:
It is not possible to make n equal to k.

 

Constraints:

1 <= n, k <= 106
 */
public class minChanges {
    public static void main(String[] args) {
        int n = 44;
        int k = 2;

        System.out.println(minChanges(n,k));

    }

    public static int minChanges(int n, int k) {

        String nStr = Integer.toBinaryString(n);
        String kStr = Integer.toBinaryString(k);

        System.out.println("nStr = " + nStr + "  kStr = " + kStr);

        int nStrLen = nStr.length();
        int kStrLen = kStr.length();

        int operationCount = 0;

        if (n == k) return 0;

        if (nStrLen > kStrLen) {
            for (int i=1; i<=(nStrLen - kStrLen); i++) {
                kStr = "0" + kStr;
            }
        }
        else if (nStrLen < kStrLen) {
            for (int i=1; i<=(kStrLen - nStrLen); i++) {
                nStr = "0" + nStr;
            }
        }

        System.out.println("After padding nStr = " + nStr + "  kStr = " + kStr);

        for (int i=0; i<nStrLen; i++) {
            if (nStr.charAt(i) != kStr.charAt(i)) {
                if (nStr.charAt(i) != '1') {
                    return -1;
                }
                else operationCount++;
            }
        }

        return operationCount;
    }

}
