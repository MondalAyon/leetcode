/*
https://leetcode.com/problems/valid-word-abbreviation/description/
https://leetcode.com/problems/valid-word-abbreviation/submissions/1511082893/

A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.

For example, a string such as "substitution" could be abbreviated as (but not limited to):

"s10n" ("s ubstitutio n")
"sub4u4" ("sub stit u tion")
"12" ("substitution")
"su3i1u2on" ("su bst i t u ti on")
"substitution" (no substrings replaced)
The following are not valid abbreviations:

"s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
"s010n" (has leading zeros)
"s0ubstitution" (replaces an empty substring)
Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.

A substring is a contiguous non-empty sequence of characters within a string.



Example 1:

Input: word = "internationalization", abbr = "i12iz4n"
Output: true
Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").
Example 2:

Input: word = "apple", abbr = "a2e"
Output: false
Explanation: The word "apple" cannot be abbreviated as "a2e".


Constraints:

1 <= word.length <= 20
word consists of only lowercase English letters.
1 <= abbr.length <= 10
abbr consists of lowercase English letters and digits.
All the integers in abbr will fit in a 32-bit integer.
 */

import java.util.ArrayList;
import java.util.List;

public class validWordAbbreviation {
    public static void main(String[] args) {

        String word = "internationalization";
        String abbr = "i12iz4n";

        //String word = "hi";
        //String abbr = "02";

        //String word = "a";
        //String abbr = "2";

        //String word = "word";
        //String abbr = "2r2";

        //String word = "leetcode";
        //String abbr = "leetc2";

        System.out.println(validWordAbbreviation(word, abbr));

    }

    public static boolean validWordAbbreviation(String word, String abbr) {

        //Basic check
        if (abbr.length() > word.length()) {
            return false;
        }

        // Tokenize the abbr.

        List<String> strList = new ArrayList<>();

        for (int i=0; i<abbr.length(); i++) {

            StringBuilder sbDigit = new StringBuilder();
            while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                sbDigit.append(abbr.charAt(i));
                i++;
            }

            if (sbDigit.length() != 0) {
                //System.out.println(sbDigit);
                strList.add(sbDigit.toString());
                i--;
            }
            else
                strList.add(String.valueOf(abbr.charAt(i)));
                //System.out.println(abbr.charAt(i));
        }


        //Now compare the main word with tokenized abbr.
        int j = 0;

        for (String str:strList) {
            //System.out.println(str);

            if (Character.isLetter(str.charAt(0))) { //checking if character between word and abbr matches.
                if (j < word.length() && str.charAt(0) != word.charAt(j)) {
                    return false;
                }
                j++;
            }
            else {
                if (str.charAt(0) == '0') { // Check for leading zero in length.
                    return false;
                }
                j += Integer.valueOf(str); //Jump the index of the abbr (which is j) to next character.
            }

            if (j > word.length()) {
                return false;
            }
        }

        if (j < word.length()) {
            return false;
        }

        return true;
    }

}
