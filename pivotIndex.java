
/*
https://leetcode.com/problems/find-pivot-index/submissions/1437346260/
https://leetcode.com/problems/find-pivot-index/description/
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.



Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
Example 2:

Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
Example 3:

Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0
 */


public class pivotIndex {
    public static void main(String[] args) {

        int[] nums = {2,1,-1};

        System.out.println(pivotIndex(nums));

    }

    /* Create the prefix sum array and iterate through the main array to check the left and right array sum to be equal.
       The prefix sum array will help to find the range sum (left and right) to calculate in constant time.
       Hence the overall runtime complexity if O(n).
     */
    public static int pivotIndex(int[] nums) {

        int len = nums.length;
        int[] prefixNums = new int[len];

        for (int i = 0; i< len; i++) {
            int k = ((i==0) ? 0 : i-1);
            prefixNums[i] += prefixNums[k] + nums[i];
        }

        //System.out.println(Arrays.toString(prefixNums));
        //System.out.println(rangeSum(prefixNums, 0,5));

        for (int i=0; i<len; i++) {

            if (i == 0) {
                if (rangeSum(prefixNums,i+1, len-1) == 0)
                    return i;

            } else if (i == len-1) {
                if (rangeSum(prefixNums, 0, len - 2) == 0)
                    return i;

            } else {
                if (rangeSum(prefixNums,0,i-1) == rangeSum(prefixNums,i+1, len-1))
                    return i;
            }
        }

        return -1;
    }

    private static int rangeSum(int[] prefixSumArray, int i, int j) {
        int sum = 0;
        if (i == 0)
            sum = prefixSumArray[j];
        else
            sum = prefixSumArray[j] - prefixSumArray[i-1];

        return sum;
    }
}
