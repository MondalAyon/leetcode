/*
https://leetcode.com/problems/longest-harmonious-subsequence/
https://leetcode.com/problems/longest-harmonious-subsequence/description/

We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious
subsequence
 among all its possible subsequences.



Example 1:

Input: nums = [1,3,2,2,5,2,3,7]

Output: 5

Explanation:

The longest harmonious subsequence is [3,2,2,2,3].

Example 2:

Input: nums = [1,2,3,4]

Output: 2

Explanation:

The longest harmonious subsequences are [1,2], [2,3], and [3,4], all of which have a length of 2.

Example 3:

Input: nums = [1,1,1,1]

Output: 0

Explanation:

No harmonic subsequence exists.

 */
import java.util.HashMap;

public class findLHS {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        //int[] nums = {1,1,1,1};

        System.out.println(findLHS(nums));

    }

    public static int findLHS(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (int i=0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]);

                if (val > maxLen)
                    maxLen = val;
            }
            else {
                int minItem = nums[i];
                int maxItem = minItem + 1;
                int count = 0;
                boolean minFound = false;
                boolean maxFound = false;

                for (int j = 0; j < nums.length; j++) {

                    if (nums[j] == maxItem) {
                        count++;
                        maxFound = true;
                    }
                    if (nums[j] == minItem) {
                        count++;
                        minFound = true;
                    }
                }
                if (minFound && maxFound) {

                    map.put(nums[i], count);
                    if (count > maxLen)
                        maxLen = count;
                }
            }
        }

        return maxLen;
    }
}
