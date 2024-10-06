/*
https://leetcode.com/problems/fair-candy-swap/submissions/1413963455/
https://leetcode.com/problems/fair-candy-swap/description/
Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of candies of the jth box of candy that Bob has.

Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box they have.
Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange, and answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer exists.

Example 1:

Input: aliceSizes = [1,1], bobSizes = [2,2]
Output: [1,2]
Example 2:

Input: aliceSizes = [1,2], bobSizes = [2,3]
Output: [1,2]
Example 3:

Input: aliceSizes = [2], bobSizes = [1,3]
Output: [2,3]
 */

import java.util.Arrays;

public class fairCandySwap {
    public static void main(String[] args) {
        int[] aliceSizes = {6,3,2};
        int[] bobSizes = {2,3,4};

        System.out.println(Arrays.toString(fairCandySwap(aliceSizes,bobSizes)));
    }

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int A = 0; // Alice's total candies.
        int B = 0; // Bob's total candies.
        int t = 0; // Total number of candies one should have after the exchange.
        int[] resultArray = new int[2]; // Per the question, resultArray[0] = what Alice gives and resultArray[1] = what Bob gives.

        for (Integer n:aliceSizes) {
            A += n;
        }

        for (Integer n:bobSizes) {
            B += n;
        }

        t = (A+B)/2;

        // Iterate through Alice's candy boxes
        for (int i=0; i<aliceSizes.length; i++) {

            int bobShouldGive = t - (A - aliceSizes[i]);

            // Check if "bobShouldGive" exists in Bob's candy box, "bobSizes"
            for (Integer bobCandybox: bobSizes) {
                if (bobCandybox == bobShouldGive) {
                    resultArray[0] = aliceSizes[i];  // Since we are iterating through "aliceSizes" hence Alice must have it.
                    resultArray[1] = bobShouldGive;
                    return resultArray;
                }
            }
        }

        return new int[]{}; // If no solution exist.
    }


}
