/*
https://leetcode.com/problems/3sum/
https://leetcode.com/problems/3sum/submissions/1595122861/

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSumV2 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        System.out.println(threeSumV2(nums));

    }

    public static List<List<Integer>> threeSumV2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i=0; i<nums.length && nums[i] <=0 ; ++i) {
            if (i == 0 || nums[i-1] != nums[i]) {
                twoSum(nums, i, result);
            }
        }

        return result;
    }

    public static void twoSum(int[] nums, int i, List<List<Integer>> result) {

        HashSet<Integer> set = new HashSet<>();

        for (int j=i+1; j<nums.length; j++) {

            int comp = -nums[i] - nums[j];

            if (set.contains(comp)) {
                result.add(Arrays.asList(nums[i], nums[j], comp));

                while (j < nums.length - 1 && nums[j + 1] == nums[j]) {
                    j++;
                }
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
            }
            else {
                set.add(nums[j]);
            }
        }


    }
}
