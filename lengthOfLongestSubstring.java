/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1420884623/

https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/5906935/sliding-window-using-two-pointers-o-n-o-1/


Given a string s, find the length of the longest
substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class lengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));

    }

    /*

    Sliding window, using two pointers.

    Use pointers (j,i) to marks the sliding window.
    Extend the window by doing i++
    If the newly added charecter already exists in the window then reduce the left edge of window (j++).
    Find length and compare with previous length to find max length.
     */
    public static int lengthOfLongestSubstring(String s) {

        int i = 1;
        int j = 0;
        int maxLen = Integer.MIN_VALUE;
        int len = 0;

        if (s.length()==0 || s.length() == 1) return s.length();

        while (i<s.length()) {

            // Check if the window string (s.substring(j,i)) already contains the new value
            while (s.substring(j,i).contains(String.valueOf(s.charAt(i)))) {
                j++;
            }
                len = i - j + 1;

                if (len > maxLen)
                    maxLen = len;

                i++;
        }

        return maxLen;
    }
}


