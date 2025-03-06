/*
https://leetcode.com/problems/longest-consecutive-sequence/description/
https://leetcode.com/problems/longest-consecutive-sequence/submissions/1563414806/

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
import java.util.HashMap;
import java.util.HashSet;

public class longestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};

        //System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutiveV2(nums));

    }

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> numSet = new HashSet<>();

        for (Integer n: nums) {
            numSet.add(n);
        }

        int maxLen = 0;

        for (Integer n:numSet) {

            if (!numSet.contains(n - 1)) {
                int currentNum = n;
                int currentLen = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLen += 1;
                }

                //maxLen = (currentLen > maxLen ? currentLen : maxLen);
                maxLen = Math.max(currentLen, maxLen);
            }
        }

        return maxLen;
    }

    public static int longestConsecutiveV2(int[] nums) {

        //HashSet<Integer> numSet = new HashSet<>();
        HashMap<Integer, Boolean> numset = new HashMap<Integer, Boolean>();

        for (Integer n: nums) {
            numset.put(n, false);
        }

        int maxLen = 0;

        for (Integer n:nums) {

            if (!numset.containsKey(n-1) && !numset.get(n)) {
                int currentNum = n;
                int currentLen = 1;
                numset.put(n, true);

                while (numset.containsKey(currentNum + 1)) {
                    currentNum += 1;
                    currentLen += 1;
                    numset.put(currentNum - 1, true);
                }

                //maxLen = (currentLen > maxLen ? currentLen : maxLen);
                maxLen = Math.max(currentLen, maxLen);
            }
        }

        return maxLen;
    }
}
