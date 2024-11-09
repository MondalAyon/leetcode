/*
https://leetcode.com/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150
You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
 

Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
nums is sorted in ascending order.
 */

import java.util.ArrayList;
import java.util.List;

public class summaryRanges {
    public static void main(String[] args) {

        int[] nums = {0,1,2,4,5,7};

        System.out.println(summaryRanges(nums));

    }

    public static List<String> summaryRanges(int[] nums) {

        List<String> resultList = new ArrayList<>();
        int i = 0;
        int j = 0;
        int s = 0;

        if (nums.length == 0) return new ArrayList<>();

        int[] nums2 = new int[nums.length+1];

        for (int k=0; k<nums.length; k++)
            nums2[k] = nums[k];
        nums2[nums2.length-1] = nums[nums.length-1];

        while (j<nums2.length-1) {

            if (nums2[i] + 1 != nums2[j+1]) {

                if (s==j) {
                    resultList.add(String.valueOf(nums2[s]));
                }
                else {
                    resultList.add(String.valueOf(nums2[s]) + "->" + String.valueOf(nums2[j]));
                }
                s = j+1;
            }

            i++;
            j++;
        }
        return resultList;
    }

}
