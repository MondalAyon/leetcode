/*
https://leetcode.com/problems/sort-array-by-parity/description/
https://leetcode.com/problems/sort-array-by-parity/submissions/1425047946/

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.



Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]
 */

import java.util.Arrays;

public class sortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {0,2,1};

        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    public static int[] sortArrayByParity(int[] nums) {

        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;

        for (int k=0; k<nums.length; k++) {

            if (nums[k]%2 == 0) {
                result[i++] = nums[k];
            }
            else result[j--] = nums[k];
        }

        return result;
    }
}
