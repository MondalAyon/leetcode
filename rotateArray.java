/*
https://leetcode.com/problems/rotate-array/description/
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */

public class rotateArray {
    public static void main (String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        //int[] nums = {-1,-100,3,99, 6,4,3};

        printArray(nums);
        //rotate(nums, 4);

       // rotateV2(nums, 2);

        rotateV3(nums, 6);
    }

    public static void rotateV3(int[] nums, int k) {

        /* Solution with O(n), but requires extra space - temp int[L-K] */

        k = k%nums.length;
        System.out.println("Effective K = " + k);

        int[] temp = new int[nums.length-k];

        for (int i=0; i<nums.length-k; i++) {
            temp[i] = nums[i];
        }

        for (int i=0; i<=(k-1); i++) {

            int s = (nums.length -k + i) % nums.length;
            nums[i] = nums[s];
        }

        for (int i=k; i< nums.length; i++) {
            nums[i] = temp[i-k];
        }


        printArray(nums);
    }


    public static void rotateV2(int[] nums, int k) {

        /* WIP */

        k = k%nums.length;
        System.out.println("Effective K = " + k);

        int temp = nums[k];

        for (int i=0; i<=(k-1); i++) {

            int t = nums[i];
            int s = (nums.length -k + i) % nums.length;

            nums[i] = nums[s];
            nums[s-1] = t;
        }

        nums[nums.length-1] = temp;

        printArray(nums);
    }

    public static void rotate(int[] nums, int k) {

        /* Working but due O(n^2), time limit exceeding */

        k = k%nums.length;
        System.out.println("Effective K = " + k);

        for (int i=1; i<=k; i++) {
            int temp = nums[nums.length-1];

            for (int j=nums.length-1; j>=1; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }

        printArray(nums);
    }

    private static void printArray(int[] nums) {
        for (int i=0; i<nums.length; i++)
            System.out.print(nums[i] + " ");
    }

}
