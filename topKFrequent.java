/*
https://leetcode.com/problems/top-k-frequent-elements/submissions/1396138685/
https://leetcode.com/problems/top-k-frequent-elements/description/

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
import java.util.*;

public class topKFrequent {
    public static void main(String[] args) {
        //int[] nums = {1,2};
        int[] nums = {4,4,0,3,3,3,3,5,5,5};
        int k = 2;

        //int[] result = topKFrequent(nums, k);
        int[] result = topKFrequentV2(nums, k);

        System.out.println();
        for (int n:result) System.out.print(n + " ");

    }

    /* Better accepted solution using Priority Queue / Heap */
    public static int[] topKFrequentV2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for (Integer n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1 );
        }
        System.out.println(map);

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a,b) -> b.getValue().compareTo(a.getValue())
        );
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            maxHeap.add(entry);
        }

        int i=0;
        while (!maxHeap.isEmpty() && i < k) {
            //System.out.print(maxHeap.poll() + " ");
            result[i] = maxHeap.poll().getKey();
            i++;
        }

        return result;
    }

    /* This is without using priority queue, fails on some test cases like nums = 1,2 and k=2. */

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        HashMap<Integer, Integer> valueMap = new LinkedHashMap<>();

        int[] result = new int[k];

        for (int n:nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n)+1);
            }
            else map.put(n, 1);
        }

        for (int key:map.keySet()) {
            valueMap.put(map.get(key), key);
        }

        int[] valueArray = new int[valueMap.size()];
        int i=0;
        for (int key: valueMap.keySet()) {
            valueArray[i] = key;
            i++;
        }

        System.out.println(map);
        System.out.println(valueMap);

        Arrays.sort(valueArray);

        for (int n:valueArray) System.out.print(n + " ");

        int j = valueArray.length - 1;
        int l = 0;
        while (k > 0) {
            result[l] = valueMap.get(valueArray[j]);
            l++;
            j--;
            k--;
        }
        return result;
    }
}
