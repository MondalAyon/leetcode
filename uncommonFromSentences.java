/*
https://leetcode.com/problems/uncommon-words-from-two-sentences/submissions/1413820064/
https://leetcode.com/problems/uncommon-words-from-two-sentences/description/

A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"

Output: ["sweet","sour"]

Explanation:

The word "sweet" appears only in s1, while the word "sour" appears only in s2.

Example 2:

Input: s1 = "apple apple", s2 = "banana"

Output: ["banana"]
 */
import java.util.Arrays;
import java.util.HashMap;

public class uncommonFromSentences {
    public static void main(String[] args) {

        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";

        /* both solution works and got submitted. V2 works with 87% less memory */

        //System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));

        System.out.println(Arrays.toString(uncommonFromSentencesV2(s1, s2)));

    }

    public static String[] uncommonFromSentencesV2(String s1, String s2) {

        String[] strArray = (s1 + " " + s2).split("\\s+");
        int count = 0;
        String resultStr = "";

        for (int i=0; i<strArray.length; i++) {

            boolean found = false;

            for (int j=0; j<strArray.length; j++) {
                if (strArray[i].equals(strArray[j]) && i != j) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                count++;
                resultStr += strArray[i] + " ";
            }
        }

        String[] resultStrArray = new String[count];
        count = 0;

        if (resultStr.trim().length() != 0) {
            for (String s : resultStr.split("\\s+")) {
                resultStrArray[count++] = s;
            }
        }

        return resultStrArray;

    }

    public static String[] uncommonFromSentences(String s1, String s2) {

        HashMap<String, Integer> map = new HashMap<>();
        String resultStr = "";
        int count=0;

        for (String s:s1.split("\\s+")) {
            map.put(s, map.getOrDefault(s,0)+1);
        }
        for (String s:s2.split("\\s+")) {
            map.put(s, map.getOrDefault(s,0)+1);
        }

        for (String s:map.keySet()) {
            if (map.get(s) == 1) {
                resultStr += s + " ";
                count++;
            }
        }

        String[] strArray = new String[count];
        count = 0;

        if (resultStr.trim().length() != 0) {
            for (String s : resultStr.split("\\s+")) {
                strArray[count++] = s;
            }
        }

        return strArray;
    }
}
