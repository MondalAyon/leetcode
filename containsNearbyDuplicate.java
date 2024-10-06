/*
https://leetcode.com/problems/contains-duplicate-ii/submissions/1412864578/
https://leetcode.com/problems/contains-duplicate-ii/description/
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class containsNearbyDuplicate {

    public static void main(String[] args) {

        int[] nums = {1,2,3,1,2,3};
        int k=2;

        System.out.println(containsNearbyDuplicateV3(nums,k));

    }


    public static boolean containsNearbyDuplicateV3(int[] nums, int k) {

        HashMap<Integer, Integer> dict = new HashMap<>();

        for (int i=0; i<nums.length; i++) {

            if (dict.containsKey(nums[i])) {

                int prevIndex = dict.get(nums[i]);

                if (i - prevIndex <= k) {

                    System.out.println(dict);
                    return true;
                }
                else {
                    dict.put(nums[i], i);
                }
            }
            else {
                dict.put(nums[i], i);
            }
        }

        System.out.println(dict);
        return false;
    }

    public static boolean containsNearbyDuplicateV2(int[] nums, int k) {

        /* This can be done even simpler, no need to Frequence, just HashMap<Integer, Integer> is fine. */

        // Building the following "dict" data structure
        // dict = {key: List{0=Freq, 1=prevIndex}

        List<Integer> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> dict = new HashMap<>();


        for (int i=0; i<nums.length; i++) {

            if (dict.containsKey(nums[i])) {

                List values = dict.get(nums[i]);
                int freq = (int)values.get(0);
                int prevIndex = (int)values.get(1);

                if (i - prevIndex <= k) {

                    System.out.println(dict);
                    return true;
                }
                else {
                    dict.put(nums[i], Arrays.asList(++freq, i)); // dict = {key: List{0=Freq, 1=prevIndex}
                }
            }
            else {
                dict.put(nums[i], Arrays.asList(1, i)); // dict = {key: List{0=Freq, 1=prevIndex}
            }
        }

        System.out.println(dict);
        return false;
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i=0; i<nums.length; i++) {

            //int temp = nums[i];
            int j = i +1;

            while (j<nums.length && i<=k+j) {
                if (nums[i] == nums[j]) {
                    if (Math.abs(i-j) <= k) {
                        return true;
                    }
                }
                j++;
            }
        }
        return false;
    }
}
