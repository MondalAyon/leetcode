/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
https://leetcode.com/problems/search-in-rotated-sorted-array/description/
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */
public class search {
    public static void main(String[] args) {

        //int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {1};
        int target = 3;

        //System.out.println(findPivotPointV2(nums));
        System.out.println(search(nums, target));
    }


    private static int findPivotPoint(int[] nums) {

        int s = 0;
        int e = nums.length - 1;
        int pivotIndex = 0;

        while (s <= e) {

            int m = s + (e - s) / 2;

            if (m > 0 && nums[m-1] > nums[m]) {
                pivotIndex = m;
                return pivotIndex;
            }
            else {
                s = m;
            }

        }
        return pivotIndex;
    }

    private static int findPivotPointV2(int[] nums) {

        for (int i = 0; i< nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                return i+1;
            }
        }
        return 0;
    }

    public static int search(int[] nums, int target) {

        int len = nums.length;
        int[] nums2 = new int[len];

        int pivotIndex = findPivotPointV2(nums);

        for (int i = 0; i< nums.length; i++) {
            nums2[i] = nums[(i + pivotIndex) % len];
        }

        int start = 0;
        int end = len - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums2[mid] == target) {
                return (mid + pivotIndex) % len;
            }
            if (target < nums2[mid]) {
                end = mid - 1;
            }
            else if (target > nums2[mid]) {
                start = mid + 1;
            }
        }

        return -1;
    }
}
