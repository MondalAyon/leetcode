/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/1396945901/
https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 */

import java.util.*;

public class intersectionII {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] result = new int[]{};

        result = intersect(nums1, nums2);

        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        //ArrayList<Integer> list11 = new ArrayList<>();
        //ArrayList<Integer> list12 = new ArrayList<>();

        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i=0; i<nums1.length; i++) {
            for (int j=0; j<nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    resultList.add((nums1[i]));
                    nums1[i] = Integer.MIN_VALUE;
                    nums2[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }

        int[] result = new int[resultList.size()];
        int i = 0;
        for (Integer n:resultList)
            result[i++] = n;

        return result;
    }
}
