/*
https://leetcode.com/problems/minimum-index-sum-of-two-lists/submissions/1430062905/
https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/

Given two arrays of strings list1 and list2, find the common strings with the least index sum.

A common string is a string that appeared in both list1 and list2.

A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.

Return all the common strings with the least index sum. Return the answer in any order.


Example 1:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only common string is "Shogun".
Example 2:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
Example 3:

Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
Output: ["sad","happy"]
Explanation: There are three common strings:
"happy" with index sum = (0 + 1) = 1.
"sad" with index sum = (1 + 0) = 1.
"good" with index sum = (2 + 2) = 4.
The strings with the least index sum are "sad" and "happy".

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class findRestaurant {
    public static void main(String[] args) {

        String[] list1 = {"happy","sad","good"};
        String[] list2 = {"sad","happy","good"};

        System.out.println(Arrays.toString(findRestaurant(list1, list2)));

    }


    public static String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> cMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        List<String> resultlist = new ArrayList<>();

        for (int i=0; i<list1.length; i++) {
            map.put(list1[i], map.getOrDefault(list1[i],0) + i);
        }
        for (int i=0; i<list2.length; i++) {
            if (map.containsKey(list2[i])) {

                int value = map.get(list2[i]) + i;
                cMap.put(list2[i], value);

                if (value <= min) {
                    min = value;
                }
            }
        }

        System.out.println(cMap);

        for (String str:cMap.keySet()) {
            if (cMap.get(str) == min)
                resultlist.add(str);
        }

        return resultlist.toArray(new String[resultlist.size()]);
    }
}
