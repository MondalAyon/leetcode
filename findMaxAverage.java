/*
https://leetcode.com/problems/maximum-average-subarray-ii/description/
https://leetcode.com/problems/maximum-average-subarray-ii/submissions/1420424682/

You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is greater than or equal to k that has the maximum average value and return this value.
Any answer with a calculation error less than 10-5 will be accepted.

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation:
- When the length is 4, averages are [0.5, 12.75, 10.5] and the maximum average is 12.75
- When the length is 5, averages are [10.4, 10.8] and the maximum average is 10.8
- When the length is 6, averages are [9.16667] and the maximum average is 9.16667
The maximum average is when we choose a subarray of length 4 (i.e., the sub array [12, -5, -6, 50]) which has the max average 12.75, so we return 12.75
Note that we do not consider the subarrays of length < 4.
Example 2:

Input: nums = [5], k = 1
Output: 5.00000

 */

public class findMaxAverage {
    public static void main (String[] args) {

        int[] nums = {9,7,3,5,6,2,0,8,1,9};
        int k = 6; // Minimum subarray size

        //int[] nums = {5};
        //int k = 1; // Minimum subarray size

        System.out.println(findMaxAverage(nums,k));
    }

    public static double findMaxAverage(int[] nums, int k) {

        double maxKAverage = Double.MIN_VALUE;

        if (nums.length == 1) return nums[0];

        //Initialize the sliding window sum, ws with sum of array 1 to k-th element.
        //int iWS = 0;
        //for (int i=0; i<k; i++)
        //    iWS += nums[i];


        for (int ik = k; ik <= nums.length; ik++) {

            int ws = 0;
            int maxSum = Integer.MIN_VALUE;

            //Initialize the window sum, ws with sum of array 1 to k-th element.
            for (int i=0; i<ik; i++)
                ws += nums[i];

            //Calculate the new initial sliding window sum, ws
            //ws = iWS + nums[ik-1];
            //iWS = ws;

            maxSum = ws;

            for (int i = ik; i < nums.length; i++) {

                ws += nums[i] - nums[i - ik];
                if (ws > maxSum) maxSum = ws;

            }

            double avg = (double)maxSum / (double)ik;
            if (avg > maxKAverage)
                maxKAverage = avg;
        }

        return maxKAverage;
    }
}
