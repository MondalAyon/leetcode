/*
https://leetcode.com/problems/palindrome-permutation/solutions/6531111/simple-solution-using-hashmap-on-by-ayon-jfv8/
https://leetcode.com/problems/palindrome-permutation/submissions/1572049450/
https://leetcode.com/problems/palindrome-permutation/description/

Given a string s, return true if a permutation of the string could form a palindrome and false otherwise.



Example 1:

Input: s = "code"
Output: false
Example 2:

Input: s = "aab"
Output: true
Example 3:

Input: s = "carerac"
Output: true


Constraints:

1 <= s.length <= 5000
s consists of only lowercase English letters.
 */
import java.util.HashMap;

public class canPermutePalindrome {
    public static void main(String[] args) {

        String s = "a";
        System.out.println(canPermutePalindrome(s));
    }

    public static boolean canPermutePalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        boolean result = true;

        for (Character c:s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if (s.length() % 2 == 0) { // Size is even

            for (Integer n:map.values()) {
                if (n % 2 != 0) {
                    return false;
                }
            }
        }
        else { // Size is odd

            boolean oddElement = false;

            for (Integer n:map.values()) {

                if (n % 2 != 0) {
                    if (!oddElement) {
                        oddElement = true;
                    }
                    else return false;
                }
            }
        }

        return true;
    }
}
