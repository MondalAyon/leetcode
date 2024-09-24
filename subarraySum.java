/*
https://leetcode.com/problems/subarray-sum-equals-k/submissions/1401024654/
https://leetcode.com/problems/subarray-sum-equals-k/description/
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 */

import java.util.HashMap;

public class subarraySum {
    public static void main(String[] args) {
        int[] num = {1,2,3};
        int k = 3;

        System.out.println(subarraySum(num, k));

        //System.out.println(subarraySumV2(num, k));
    }

    /* This solutions works (submitted) but in O(n^2) */
    public static int subarraySum(int[] nums, int k) {
        int subArrayCount = 0;
        int subSum = 0;

        for (int i=0; i<nums.length; i++) {

            subSum = 0;

            for (int j=i; j<nums.length; j++) {
                subSum += nums[j];
                if (subSum == k) {
                    subArrayCount++;
                    //break;

                } //else if (subSum > k) {
                  //  break;
                //}
            }
        }
        return subArrayCount;
    }

    /* Below solution is O(n) complexity, replicated from leetcode. */
    public static int subarraySumV2(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int j=0;j<nums.length;j++){
            sum += nums[j];
            if(map.containsKey(sum -k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
