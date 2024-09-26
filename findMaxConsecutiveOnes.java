/* https://leetcode.com/problems/max-consecutive-ones/submissions/1402449086/
https://leetcode.com/problems/max-consecutive-ones/description/
Given a binary array nums, return the maximum number of consecutive 1's in the array.


Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 */
public class findMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 0};

        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
       int maxLen = Integer.MIN_VALUE;
       int len = 0;

       for (int i=0; i<nums.length; i++) {
           if (nums[i] == 1) {
               len++;
           }
           else {
               maxLen = Math.max(maxLen, len);
               len = 0;
           }
       }

       maxLen = Math.max(maxLen, len);

       return maxLen;

    }

}
