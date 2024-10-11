/*
https://leetcode.com/problems/maximum-length-of-repeated-subarray/submissions/1418805168/
https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].
Example 2:

Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
Explanation: The repeated subarray with maximum length is [0,0,0,0,0].
 */

public class findLength {
    public static void main(String[] args) {

        int[] nums1 = {0,0,0,0};
        int[] nums2 = {1,1,0,0};

        System.out.println(findLengthV2(nums1, nums2));
    }

    public static int findLengthV2(int[] nums1, int[] nums2) {

        int maxLen = 0;

        for (int i=0; i<nums1.length; i++) {

            for (int j=0; j<nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    int in1 = i;
                    int in2 = j;
                    int len = 0;
                    while (in1 < nums1.length && in2 < nums2.length) {
                        if (nums1[in1] == nums2[in2]) {
                            len++;
                            in1++;
                            in2++;
                        }
                        else break;
                    }
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }

}
