/*
https://leetcode.com/problems/single-number-ii/description/
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.


Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 */
import java.util.Arrays;

public class singleNumber2 {

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }


    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        int i = 0;
        int result = -1;

        while (i<l) {
            if (i==l-1){
                result = nums[i];
                break;
            }

            if (nums[i]==nums[i+1] && nums[i+1]==nums[i+2]) {
                i = i + 3;
            }
            else {
                result = nums[i];
                break;
            }
        }
        return result;
    }
}
