/*
https://leetcode.com/problems/contiguous-array/submissions/1421476983/
https://leetcode.com/problems/contiguous-array/description/

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.


 */

import java.util.HashMap;

public class findMaxLength {
    public static void main(String[] args) {
        int[] nums = {0,0,1,0,0,0,1,1};

        //System.out.println(findMaxLength(nums));

        System.out.println(findMaxLengthV3(nums));

        //System.out.println(findMaxConsequetiveOnesLength(nums));

        //System.out.println(findMaxConsecutiveOnes(nums));

        //System.out.println(canWin(3, nums));
    }

    /* Working and git submitted to leetcode -

    1. Find running sum while replace 0s with -1, such that running sum becomes zero for a substring that has equal number of 0 and 1.
2. Use a hasmap to store the running sum and corresponding index.
3. len = i - last running sum index.
3. Loop around the I/P array and do Step1 and 2 to find the max len.

     */
    public static int findMaxLengthV3(int[] nums) {

        HashMap<Integer, Integer> psMap = new HashMap<>();
        psMap.put(0, -1);

        int maxLen = 0;
        int len = 0;
        int pSum = 0;

        for (int i=0; i<nums.length; i++) {

            pSum += (nums[i] == 0 ? -1 : nums[i]); // Equivalent of substituting the 0s with -1 in the I/P array.

            if (psMap.containsKey(pSum)) {

                len = i - psMap.get(pSum);

                if (len > maxLen)
                    maxLen = len;
            }
            else {
                psMap.put(pSum, i);
            }
        }

        return maxLen;
    }


    /* WIP version, not complete */
    public static int findMaxLengthV2(int[] nums) {
        int maxLen = Integer.MIN_VALUE;
        int inputArrayLen = nums.length;

        if (inputArrayLen == 0 || inputArrayLen == 1) return 0;

        int j = 0;
        int i = 1;
        int sum = nums[j];

        while (i < inputArrayLen) {

            int len = i - j + 1;
            sum += nums[i];

            if ((double)sum == (double)len / 2.0) {
                if (len > maxLen)
                    maxLen = len;
            }

            i++;
        }

        return maxLen;
    }

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.

        int i = 0;
        if (i + leap >= game.length - 1) return true;

        while ((game.length - 1) - i > leap) {
            if (game[i + leap] == 0) {
                i += leap;
            } else {
                return false;
            }
        }
        return true;
    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {

            if (num == 1) {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }

    private static int findMaxConsequetiveOnesLength(int[] nums) {
        int MaxLen = 0;
        int len = 0;

        for (int i=0; i<nums.length; i++) {

            if (nums[i] == 1) {
                len++;

            }
            else {
                MaxLen = Math.max(len, MaxLen);
                len = 0;
            }
        }

        MaxLen = Math.max(len, MaxLen);

        return MaxLen;
    }

    public static int findMaxLength(int[] nums) {
        int maxLen = 0;
        int inputArrayLen = nums.length;


        for (int i = 0; i < inputArrayLen; i++) {

            if (inputArrayLen - i <= maxLen) return maxLen;

            for (int j = i + 1; j < inputArrayLen; j += 2) {

                int totalSubArrayElement = j - i + 1;
                int sum = 0;
                for (int k = i; k <= j; k++)
                    sum += nums[k];

                if (sum * 2 == totalSubArrayElement) {
                    if (maxLen < totalSubArrayElement)
                        maxLen = totalSubArrayElement;
                }
            }
        }

        return maxLen;
    }
}
