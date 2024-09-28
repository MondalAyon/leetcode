/*
https://leetcode.com/problems/k-diff-pairs-in-an-array/submissions/1405467764/
https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.

Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:

Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:

Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findPairs {
    public static void main(String[] args) {
        int[] nums = {1,3,1,5,4};
        int k = 0;

        //System.out.println(findPairs(nums, k));
        System.out.println(findPairsV2(nums, k));

    }

    /* This one is modified version, making use of Binary Search, Complexity O(n.long(n))
    * Submitted and better runtime.  */
    public static int findPairsV2(int[] nums, int k) {
        Set<String> resultSet = new HashSet<>();
        int itemToFound = 0;
        int itemIndex = 0;

        int min = 0;
        int max = 0;
        String setElement = "";

        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            itemToFound = nums[i] + k;

            itemIndex = binarySearch(nums, i+1, itemToFound);

            if (itemIndex != -1) {
                min = Math.min(nums[i], nums[itemIndex]);
                max = Math.max(nums[i], nums[itemIndex]);

                setElement = String.valueOf(min) + "," + String.valueOf(max);
                resultSet.add(setElement);
            }
        }
        System.out.println(resultSet);
        return resultSet.size();
    }

    private static int binarySearch(int[] array, int startIndex, int item) {

        int start = startIndex;
        int end = array.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (array[mid] == item) return mid;

            if (item < array[mid]) {
                end = mid - 1;
            }
            else if (item > array[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    /* This is O(n^2). Got submitted in leetcode but the runtime is long */
    public static int findPairs(int[] nums, int k) {
        int min = 0;
        int max = 0;
        String setElement = "";
        Set<String> resultSet = new HashSet<>();

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) == k) {
                    min = Math.min(nums[i], nums[j]);
                    max = Math.max(nums[i], nums[j]);
                    setElement = String.valueOf(min) + "," + String.valueOf(max);
                    resultSet.add(setElement);
                }
            }
        }
        System.out.println(resultSet);
        return resultSet.size();
    }
}
