/*
https://leetcode.com/problems/find-anagram-mappings/submissions/1417720174/
https://leetcode.com/problems/find-anagram-mappings/description/
You are given two integer arrays nums1 and nums2 where nums2 is an anagram of nums1. Both arrays may contain duplicates.

Return an index mapping array mapping from nums1 to nums2 where mapping[i] = j means the ith element in nums1 appears in nums2 at index j. If there are multiple answers, return any of them.

An array a is an anagram of an array b means b is made by randomizing the order of the elements in a.

 

Example 1:

Input: nums1 = [12,28,46,32,50], nums2 = [50,12,32,46,28]
Output: [1,4,3,2,0]
Explanation: As mapping[0] = 1 because the 0th element of nums1 appears at nums2[1], and mapping[1] = 4 because the 1st element of nums1 appears at nums2[4], and so on.
Example 2:

Input: nums1 = [84,46], nums2 = [84,46]
Output: [0,1]

 */

import java.util.Arrays;
import java.util.HashMap;

public class anagramMappings {
    public static void main(String[] args) {
        int[] nums1 = {12,28,46,32,50};
        int[] nums2 = {50,12,32,46,28};

        System.out.println(Arrays.toString(anagramMappings(nums1,nums2)));

    }

    public static int[] anagramMappings(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> mapNum2 = new HashMap<>();

        for (int i=0; i<nums2.length; i++) {
            mapNum2.put(nums2[i], i);
        }

        for (int i=0; i<nums1.length; i++) {
            result[i] = mapNum2.get(nums1[i]);
        }

        return result;
    }
}
