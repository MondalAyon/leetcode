/*
https://leetcode.com/problems/intersection-of-two-arrays/submissions/1396174366/
https://leetcode.com/problems/intersection-of-two-arrays/description/
Given two integer arrays nums1 and nums2, return an array of their
intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class intersection {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] result = new int[]{};

        result = intersection(nums1, nums2);

        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        ArrayList<Integer> resultArray = new ArrayList<>();

        for (Integer n:nums1) {
            set1.add(n);
        }
        for (Integer n:nums2) {
            set2.add(n);
        }

        for (Integer n:set1) {
            if (set2.contains(n)) {
                resultArray.add(n);
            }
        }

        int[] result = new int[resultArray.size()];

        int i=0;
        for (int n: resultArray) {
            result[i++] = n;
        }
        return result;
    }
}
