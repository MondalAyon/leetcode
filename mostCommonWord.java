/*
https://leetcode.com/problems/most-common-word/submissions/1598793477/
https://leetcode.com/problems/most-common-word/description/
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.



Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
Example 2:

Input: paragraph = "a.", banned = []
Output: "a"


Constraints:

1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.
 */
import java.util.HashMap;
import java.util.HashSet;

public class mostCommonWord {
    public static void main(String[] args) {

        //String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        //String[] banned = {"hit"};

        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};

        System.out.println(mostCommonWord(paragraph, banned));

    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        HashSet<String> bannedWordSet = new HashSet<>();
        HashMap<String, Integer> mapWord = new HashMap<>();
        int max = 0;
        String resultStr = "";

        for (String s: banned) {
            s.toLowerCase();
            bannedWordSet.add(s);
        }

        for (String str :paragraph.split("\\s|(,)")) {

            str = str.replace("!", "")
                    .replace("?","")
                    .replace("'","")
                    .replace(",","")
                    .replace(";","")
                    .replace(".","")
                    .replace(" ","");

            str = str.toLowerCase();

            //System.out.print(str);

            if (!bannedWordSet.contains(str) && str != "") {
                int n = mapWord.getOrDefault(str, 0) + 1;
                mapWord.put(str, n);
                max = Math.max(max, n);
            }
        }

        for (String str:mapWord.keySet()) {
            if (mapWord.get(str) == max) {
                resultStr = str;
            }
        }

        return resultStr;
    }
}
