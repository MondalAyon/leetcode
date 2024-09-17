/*
https://leetcode.com/problems/word-pattern/submissions/1392765867/
https://leetcode.com/problems/word-pattern/description/

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.


Example 1:

Input: pattern = "abba", s = "dog cat cat dog"

Output: true

Explanation:

The bijection can be established as:

'a' maps to "dog".
'b' maps to "cat".
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"

Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"

Output: false
 */
import java.util.HashMap;

public class wordPattern {
    public static void main(String[] args) {

        String pattern = "ab";
        String str = "dog cat dog";

        System.out.println(wordPattern(pattern, str));

    }

    public static boolean wordPattern(String pattern, String s) {

        HashMap<String, String> mapKeyValue = new HashMap<>();
        HashMap<String, String> mapValueKey = new HashMap<>();
        String[] strArray = s.split("\\s");

        if (pattern.length() != strArray.length) return false;

        int i = 0;
        for (String str:strArray) {
            String key = pattern.substring(i,i+1);

            if (mapKeyValue.containsKey(key)) { //Check for the (same) Key

                if (!mapKeyValue.get(key).equals(str))
                    return false;

            }
            else  mapKeyValue.put(key, str);

            i++;
        }

        for (int j=0; j<pattern.length(); j++) { //Check for the (same) value
            String value = pattern.substring(j,j+1);

            if (mapValueKey.containsKey(strArray[j])) {

                if (!mapValueKey.get(strArray[j]).equals(value))
                    return false;
            }
            else mapValueKey.put(strArray[j], value);
        }

        return true;
    }
}
