/*
https://leetcode.com/problems/single-number/description/
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
*/

import java.util.Arrays;

public class singleNumber {
    public static void main(String[] args) {
        //int[] nums = {0,1,0,1,0,1,99};

        int[] nums = {1};

        System.out.println(singleNumber(nums));

    }

    public static int singleNumber(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        Arrays.sort(nums);

        int i=0;
        while (true) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
            i+=2;

            if (i==nums.length-1) {
                return nums[i];
            }
        }
    }

}
