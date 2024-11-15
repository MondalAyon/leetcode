/*
https://leetcode.com/problems/missing-ranges/submissions/1453279358/
https://leetcode.com/problems/missing-ranges/description/
You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the shortest sorted list of ranges that exactly covers all the missing numbers. That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.
Example 1:

Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: [[2,2],[4,49],[51,74],[76,99]]
Explanation: The ranges are:
[2,2]
[4,49]
[51,74]
[76,99]
Example 2:

Input: nums = [-1], lower = -1, upper = -1
Output: []
Explanation: There are no missing ranges since there are no missing numbers.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findMissingRanges {
    public static void main(String[] args) {

        int[] nums = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;

        //int[] nums = {-1};
        //int lower = -1;
        //int upper = 3;

        //int[] nums = {5,8};
        //int lower = 0;
        //int upper = 9;

        System.out.println(findMissingRanges(nums, lower, upper));

    }

    public static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {

        List<List<Integer>> resultList = new ArrayList<>();

        if (nums.length == 0) {
            resultList.add(Arrays.asList(lower,upper));
            return resultList;
        }

        int start;
        int end;

        // Lower boundary handle
        start = lower;
        end = nums[0];

        if ((end - start) >= 1) {
            end = nums[0] - 1;
            resultList.add(Arrays.asList(start, end));
        }

        for (int i=0; i<nums.length-1; i++) {

            start = nums[i];
            end = nums[i+1];

            if ((end - start) > 1) {
                start = nums[i] + 1;
                end = nums[i+1] - 1;
                resultList.add(Arrays.asList(start, end));
            }
        }

        // Upper boundary handle
        start = nums[nums.length-1];
        end = upper;

        if ((end - start) >= 1) {
            start = nums[nums.length-1] + 1;
            resultList.add(Arrays.asList(start, end));
        }

        return resultList;
    }

}
