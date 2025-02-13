/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1541146734/
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/6415379/runtime-olog-n-beats-100-using-binary-se-8xex/

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */
import java.util.Arrays;

public class searchRange {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2};
        int target = 2;

        System.out.println(Arrays.toString(searchRange(nums,target)));

    }

    public static int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        boolean found = false;
        int rStart = 0;
        int rEnd = 0;

        while (end >= start) {

            mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                found = true;
                rStart = mid;
                rEnd = mid;

                while (rStart > 0) {
                    if (nums[rStart -1] == target) {
                        rStart--;
                    }
                    else break;
                }

                while (rEnd < nums.length-1) {
                    if (nums[rEnd + 1] == target) {
                        rEnd++;
                    }
                    else break;
                }

                break;
            }

            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
        }

        int[] result = new int[2];
        if (found) {
            result[0] = rStart;
            result[1] = rEnd;
        }
        else {
            result[0] = -1;
            result[1] = -1;
        }

        return result;

    }
}
