/*
https://leetcode.com/problems/squares-of-a-sorted-array/solutions/6468616/beats-100-runtime-complexity-on-sort-mer-ikic/
https://leetcode.com/problems/squares-of-a-sorted-array/description/

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
import java.util.Arrays;

public class sortedSquares {

    public static void main (String[] args) {

        int[] nums = {-4,-1,0,3,10};

        System.out.println(Arrays.toString(sortedSquares(nums)));

    }


    public static int[] sortedSquares(int[] nums) {

        /* 1. Find the point in the array where from the positive numbers starts, basically logically partition -ve set anf positive set.
              e.g. nums = {-4,-1,0,3,10}; => {-4, -1} and {0,3,10}
           2. Merge sort the above two list, but consider {-4, -1} in the reverse sorted way. Handle that in the merge step.
           3. Handle scenario where all numbers are negative or all numbers are positive.
           4. Last and trivial, square the O/P.
         */

        int j = -1;
        int[] numsSorted = new int[nums.length];

        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] < 0 && nums[i+1] >=0) {
                //System.out.println(i);
                j = i;
                break;
            }
        }

        // Check for all -ve numbers in the I/P array, e.g. nums = {-5,-3,-2,-1}
        if ((j == -1) && (nums[0] < 0)) {
            for (int l=0; l<nums.length; l++) {
                numsSorted[l] = -1*nums[nums.length-1 - l];
            }
        }
        else if ( j == -1 && (nums[0] >=0)) {  // Check for all +ve numbers in the I/P array, e.g. nums = {1,2,3}
            for (int l=0; l<nums.length; l++) {
                numsSorted[l] = nums[l];
            }
        }

        else {

            int k = j + 1;
            int i = 0;

            while (j >= 0 && k < nums.length) {

                if (-1 * nums[j] < nums[k]) {
                    numsSorted[i] = -1 * nums[j];
                    i++;
                    j--;
                } else if (-1 * nums[j] >= nums[k]) {
                    numsSorted[i] = nums[k];
                    i++;
                    k++;
                }
            }

            while (j >= 0) {
                numsSorted[i] = -1 * nums[j];
                i++;
                j--;
            }

            while (k < nums.length) {
                numsSorted[i] = nums[k];
                i++;
                k++;
            }
        }

        for (int l=0; l<numsSorted.length; l++) {
            numsSorted[l] *= numsSorted[l];
        }

        return numsSorted;
    }
}
