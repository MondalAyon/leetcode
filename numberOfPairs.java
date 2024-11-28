/*
https://leetcode.com/problems/find-the-number-of-good-pairs-ii/submissions/1464649913/
https://leetcode.com/problems/find-the-number-of-good-pairs-ii/description/

You are given 2 integer arrays nums1 and nums2 of lengths n and m respectively. You are also given a positive integer k.

A pair (i, j) is called good if nums1[i] is divisible by nums2[j] * k (0 <= i <= n - 1, 0 <= j <= m - 1).

Return the total number of good pairs.



Example 1:

Input: nums1 = [1,3,4], nums2 = [1,3,4], k = 1

Output: 5

Explanation:

The 5 good pairs are (0, 0), (1, 0), (1, 1), (2, 0), and (2, 2).
Example 2:

Input: nums1 = [1,2,4,12], nums2 = [2,4], k = 3

Output: 2

Explanation:

The 2 good pairs are (3, 0) and (3, 1).



Constraints:

1 <= n, m <= 105
1 <= nums1[i], nums2[j] <= 106
1 <= k <= 103
 */

import java.util.HashMap;

public class numberOfPairs {
    public static void main(String[] args) {

        int[] nums1 = {1,2,4,12};
        int[] nums2 = {2,4};
        int k = 3;

        //System.out.println(numberOfPairs(nums1, nums2, k));
        //System.out.println(numberOfPairsV2(nums1, nums2, k));
        System.out.println(numberOfPairsV3(nums1, nums2, k));

    }

    public static int numberOfPairs(int[] nums1, int[] nums2, int k) {

        int pairCount = 0;

        for (int i=0; i<nums1.length; i++) {
            for (int j=0; j<nums2.length; j++) {

                if (nums1[i] % (nums2[j] * k) == 0) {
                    pairCount++;
                }
            }
        }

        return pairCount;
    }

    /* https://leetcode.com/problems/find-the-number-of-good-pairs-ii/submissions/1464626785/  */
    public static long numberOfPairsV2(int[] nums1, int[] nums2, int k) {

        HashMap<Integer, Integer> mapNum2 = new HashMap<>();
        long pairCount = 0;

        for (Integer num:nums2) {
            mapNum2.put(num * k, mapNum2.getOrDefault(num * k, 0) + 1);
        }

        for (Integer num:nums1) {
            for (int i = 1; i<= Math.sqrt(num); i++) {

                if (num % i == 0) {
                    if (mapNum2.containsKey(i)) {
                        pairCount += mapNum2.get(i);
                    }

                    int complement = num / i;
                    if (mapNum2.containsKey(complement) && i != complement) {
                        pairCount += mapNum2.get(complement);
                    }
                }
            }
        }

        return pairCount;
    }

    public static long numberOfPairsV3(int[] nums1, int[] nums2, int k) {

        HashMap<Integer, Integer> mapNum2 = new HashMap<>();
        long pairCount = 0;

        for (Integer num:nums2) {
            mapNum2.put(num, mapNum2.getOrDefault(num, 0) + 1);
        }

        int[] num1New = new int[nums1.length];
        int i = 0;

        for (Integer num: nums1) {

            if (num % k == 0) {
                num1New[i++] = num;
            }
        }

        for (int j = 0; j < i; j++) {
            for (int l = 1; l<= Math.sqrt(num1New[j]); l++) {

                if (num1New[j] % l == 0) {
                    if (mapNum2.containsKey(l)) {
                        pairCount += mapNum2.get(l);
                    }

                    int complement = num1New[j] / l;
                    if (mapNum2.containsKey(complement) && l != complement) {
                        pairCount += mapNum2.get(complement);
                    }
                }
            }
        }

        return pairCount;
    }
}

