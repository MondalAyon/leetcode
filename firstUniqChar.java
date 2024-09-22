/*
https://leetcode.com/problems/first-unique-character-in-a-string/submissions/1397922589/
https://leetcode.com/problems/first-unique-character-in-a-string/description/
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"

Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

Input: s = "loveleetcode"

Output: 2

Example 3:

Input: s = "aabb"

Output: -1
 */

public class firstUniqChar {
    public static void main(String[] args) {
        String s = "aabcdd";

        System.out.println(firstUniqChar(s));

    }

    public static int firstUniqChar(String s) {

        for (int i=0; i<s.length(); i++) {
            boolean repeatFound = false;
            for (int j=0; j<s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (i != j)) {
                    repeatFound = true;
                    break;
                }
            } // End of inner loop: j
            if (!repeatFound) {
                return i;
            }
        }
        return -1;
    }


}
