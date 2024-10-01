/*
https://leetcode.com/problems/array-partition/submissions/1408500540/
https://leetcode.com/problems/array-partition/description/
Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.



Example 1:

Input: nums = [1,4,3,2]
Output: 4
Explanation: All possible pairings (ignoring the ordering of elements) are:
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum possible sum is 4.
Example 2:

Input: nums = [6,2,6,5,1,2]
Output: 9
Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class arrayPairSum {
    public static void main(String[] args) {
        int[] nums = {6,2,6,5,1,2};

        //System.out.println(arrayPairSum(nums));
        System.out.println(arrayPairSumV2(nums));
    }


    public static int arrayPairSumV2(int[] nums) {
        int result = 0;

        Arrays.sort(nums);

        for (int i=0; i<nums.length; i+=2) {
            result += Math.min(nums[i],nums[i+1]);
        }

        return result;
    }

    public static int arrayPairSum(int[] nums) {
        int result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> b.compareTo(a)
        );

        for (Integer n:nums)
            pq.add(n);

        //while (!pq.isEmpty())
        //    System.out.print(pq.poll() + " ");

        while (!pq.isEmpty()) {
            result += Math.min(pq.poll(), pq.poll());
        }

        return result;
    }

}
