/*
https://leetcode.com/problems/find-lucky-integer-in-an-array/submissions/1635174800/
https://leetcode.com/problems/find-lucky-integer-in-an-array/description/
Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer return -1.



Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
Example 2:

Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
Example 3:

Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.


Constraints:

1 <= arr.length <= 500
1 <= arr[i] <= 500

 */
import java.util.HashMap;

public class findLucky {
    public static void main(String[] args) {

        int[] arr = {1,2,2,3,3,3};

        System.out.println(findLucky(arr));

    }

    public static int findLucky(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLucky = -1;

        for (int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Integer i:map.keySet()) {
            if (map.get(i) == i) {
                maxLucky = Math.max(maxLucky, i);
            }
        }
        return maxLucky;
    }
}
