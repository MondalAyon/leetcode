/*
https://leetcode.com/problems/shortest-distance-to-a-character/
https://leetcode.com/problems/shortest-distance-to-a-character/description/

Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.

The distance between two indices i and j is abs(i - j), where abs is the absolute value function.



Example 1:

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
Example 2:

Input: s = "aaab", c = "b"
Output: [3,2,1,0]


Constraints:

1 <= s.length <= 104
s[i] and c are lowercase English letters.
It is guaranteed that c occurs at least once in s.
 */
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class shortestToChar {

    public static void main(String[] args) {
        String s = "aaab";
        char c = 'b';

        System.out.println(Arrays.toString(shortestToChar(s,c)));
    }

    public static int[] shortestToChar(String s, char c) {

        Set<Integer> list = new LinkedHashSet<>();
        list.add(Integer.MAX_VALUE);

        int[] resultIndex = new int[s.length()];

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == c) {
                list.add(i);
            }
        }

        //System.out.println(list);

        //int[] indexList = new int[list.size()];
        //for (int i= 0; i<list.size(); i++) {
        //    indexList[i] = (int) list.toArray()[i];
        //}

        int j = 1;
        for (int i=0; i< s.length(); i++) {

            if (i > (int)list.toArray()[j]) {
                j++;
            }

            if (j >= list.size() - 1)
                j = list.size() - 1;

            int min = Math.min(Math.abs(i - (int)list.toArray()[j-1]), Math.abs(i - (int)list.toArray()[j]));
            resultIndex[i] = min;

        }

        return resultIndex;
    }

}
