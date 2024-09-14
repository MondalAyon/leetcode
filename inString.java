/*
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/submissions/1389390571/

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */

public class inString {
    private String haystack = "";
    private String needle = "";

    public inString() {
        this.haystack = "";
        this.needle = "";
    }

    public inString(String haystack, String needle) {
        this.haystack = haystack;
        this.needle = needle;
    }

    public void Set(String haystack) {
        this.haystack = haystack;
    }
    public void Set(String haystack, String needle) {
        this.haystack = haystack;
        this.needle = needle;
    }

    /* Using substring, working fine */
    public int GetV2(String needle) {

        if (needle.length() > haystack.length()) return -1;

        for (int i=0; i <= haystack.length() - needle.length(); i++) {
                if (haystack.substring(i, i+needle.length()).equals(needle))
                    return i;
            }

        return -1;
    }

    public static void main(String[] args) {

        inString obj = new inString();
        obj.Set("babba");
        int idx = obj.GetV2("bb");
        System.out.println("Found at index (0 based): " + idx);
    }


}
