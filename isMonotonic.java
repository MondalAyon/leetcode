/* Solution: https://leetcode.com/problems/monotonic-array/solutions/5879437/java-simple-conditional-check/
https://leetcode.com/problems/monotonic-array/submissions/1414118796/
https://leetcode.com/problems/monotonic-array/description/
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic, or false otherwise.

Example 1:

Input: nums = [1,2,2,3]
Output: true
Example 2:

Input: nums = [6,5,4,4]
Output: true
Example 3:

Input: nums = [1,3,2]
Output: false



*/

public static boolean isMonotonic(int[] nums) {

        boolean incrFlag = false;
        boolean dcrFlag = false;

        for (int i=0; i<nums.length-1; i++) {

            if (nums[i] > nums[i+1]) {
                if (dcrFlag == false) {
                    incrFlag = true;
                }
                else return false;
            }

            if (nums[i] < nums[i+1]) {
                if (incrFlag == false) {
                    dcrFlag = true;
                }
                else return false;
            }

            if (nums[i] == nums[i+1]) {
                continue;
            }

        }

        return true;
    }
