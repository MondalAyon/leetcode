/*
https://leetcode.com/problems/longest-common-prefix/submissions/1377014272/
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 */

public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        //String[] strs = {"ab","a"};

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String resultStr = "";
        int j=0;
        boolean match = false;
        //resultStr = strs[0].substring(0,1);

        if (strs.length == 1) return strs[0];

        // find the shortest string length
        int minLength = Integer.MAX_VALUE;
        for (String s: strs) {
            if (s.length() < minLength) minLength = s.length();
        }

        while (j < minLength) {
            for (int i = 0; i < strs.length - 1; i++) {

                if (strs[i].length() != 0) {
                    if (strs[i].substring(j, j + 1).equals(strs[i + 1].substring(j, j + 1))) {
                        match = true;
                    } else {
                        match = false;
                        break;
                    }
                }
            }
            if (match) {
                resultStr = resultStr + strs[0].substring(j, j + 1);
                j++;
            } else {
                return resultStr;
            }
        }
        return resultStr;
    }
}
