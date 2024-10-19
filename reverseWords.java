/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/submissions/1426911151/
https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
https://leetcode.com/problems/reverse-words-in-a-string-iii/solutions/5934582/simple-and-faster-o-n/

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.



Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "Mr Ding"
Output: "rM gniD"
 */

import java.util.Stack;

public class reverseWords {
    public static void main(String[] args) {

        String s = "Let's take LeetCode contest";

        System.out.println(reverseWordsV3(s));

    }

    /* Fastest solution using Stringbuilder and O(n) */
    public static String reverseWordsV3(String s) {

        StringBuilder sbResultStr = new StringBuilder();
        StringBuilder sbtempStr = new StringBuilder();

        s += " ";

        for (Character c:s.toCharArray()) {

            if (c != ' ') {
                sbtempStr.append(c);
            }
            else {
                sbResultStr.append(sbtempStr.reverse()).append(c);
                sbtempStr.delete(0,sbtempStr.length());
            }
        }

        return sbResultStr.toString().trim();
    }

    public static String reverseWordsV2(String s) {

        Stack<Character> st = new Stack<>();
        String resultStr = "";

        for (Character c : s.toCharArray()) {

            if (c != ' ') {
                st.push(c);
            }
            else {
                if (st.isEmpty())
                    resultStr += c;
                else
                    while (!st.isEmpty())
                        resultStr += st.pop();

                    resultStr += c;
            }
        }
        while (!st.isEmpty())
            resultStr += st.pop();

        return resultStr;
    }

    public static String reverseWords(String s) {

        String[] strArray = s.split("\\ +");
        String resultStr = "";

        for (String str:strArray) {

            String temp = "";

            for (int i=str.length()-1; i>=0; i--) {
                temp += str.charAt(i);
            }

            resultStr += temp + " ";

        }

        return resultStr.trim();
    }
}
