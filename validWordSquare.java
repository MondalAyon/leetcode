/*
https://leetcode.com/problems/valid-word-square/description/
https://leetcode.com/problems/valid-word-square/submissions/1551531303/
Given an array of strings words, return true if it forms a valid word square.

A sequence of strings forms a valid word square if the kth row and column read the same string, where 0 <= k < max(numRows, numColumns).



Example 1:


Input: words = ["abcd","bnrt","crmy","dtye"]
Output: true
Explanation:
The 1st row and 1st column both read "abcd".
The 2nd row and 2nd column both read "bnrt".
The 3rd row and 3rd column both read "crmy".
The 4th row and 4th column both read "dtye".
Therefore, it is a valid word square.
Example 2:


Input: words = ["abcd","bnrt","crm","dt"]
Output: true
Explanation:
The 1st row and 1st column both read "abcd".
The 2nd row and 2nd column both read "bnrt".
The 3rd row and 3rd column both read "crm".
The 4th row and 4th column both read "dt".
Therefore, it is a valid word square.
Example 3:


Input: words = ["ball","area","read","lady"]
Output: false
Explanation:
The 3rd row reads "read" while the 3rd column reads "lead".
Therefore, it is NOT a valid word square.


Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 500
words[i] consists of only lowercase English letters.
 */
import java.util.ArrayList;
import java.util.List;

public class validWordSquare {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("abc");
        words.add("b");
        //words.add("let");
        //words.add("lep");

        //int n = 5;
        //System.out.println(String.format("%-"+ n + "s", "let").replace(' ', '0'));

        System.out.println(validWordSquare(words));

    }

    public static boolean validWordSquare(List<String> words) {

        int maxWordLen = 0;

        for (String word:words) {
            if (maxWordLen < word.length()) {
                maxWordLen = word.length();
            }
        }

        if (maxWordLen != words.size()) {
            return false;
        }

        List<String> newWords = new ArrayList<>();

        for (int i=0; i<words.size(); i++) {
            String word = words.get(i);
            word = String.format("%-" + maxWordLen + "s", word).replace(' ','0');
            newWords.add(word);
        }

        System.out.println(newWords);

        for (int i=0; i<newWords.size(); i++) {

            String str = "";

            for (int j=0; j<newWords.get(i).length(); j++) {
                str += newWords.get(j).charAt(i);
            }

            if (!str.equals(newWords.get(i))) {
                return false;
            }
        }
        return true;
    }
}
