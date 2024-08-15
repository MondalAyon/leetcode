/* Problem:
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. Y
ou may assume that the majority element always exists in the array.
Source: https://leetcode.com/problems/majority-element/description/
*/

import java.util.HashMap;

public class majorityElement {
    public static void main (String[] args) {
        int[] nums = {1,2,3};

        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {

        HashMap<Integer, Integer> resultMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (resultMap.containsKey(nums[i])) {
                resultMap.put(nums[i], resultMap.get(nums[i])+1);
            }
            else {
                resultMap.put(nums[i], 1);
            }
        }
        System.out.println(resultMap);

        for (Integer i: resultMap.keySet()) {
            if (resultMap.get(i) > nums.length/2) {
                return i;
            }
        }
        return -1;
    }
}
