/*
https://leetcode.com/problems/keyboard-row/description/
https://leetcode.com/problems/keyboard-row/submissions/1503598262/

Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

Note that the strings are case-insensitive, both lowercased and uppercased of the same letter are treated as if they are at the same row.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".

Example 1:

Input: words = ["Hello","Alaska","Dad","Peace"]

Output: ["Alaska","Dad"]

Explanation:

Both "a" and "A" are in the 2nd row of the American keyboard due to case insensitivity.

Example 2:

Input: words = ["omk"]

Output: []

Example 3:

Input: words = ["adsdf","sfd"]

Output: ["adsdf","sfd"]



Constraints:

1 <= words.length <= 20
1 <= words[i].length <= 100
words[i] consists of English letters (both lowercase and uppercase). 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findWords {
    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};

        System.out.println(Arrays.toString(findWords(words)));


    }

    public static String[] findWords(String[] words) {

        String firstLine = "qwertyuiop";
        String secondLine = "asdfghjkl";
        String thirdLine = "zxcvbnm";

        List<String> resultList= new ArrayList<>();

        for (String str:words) {

            boolean firstLineFlag = true;
            boolean secondLineFlag = true;
            boolean thrirdLineFlag = true;

            for (Character c:str.toLowerCase().toCharArray()) {
                if (firstLine.indexOf(c) == -1) {
                    firstLineFlag = false;
                    break;
                }
            }

            if (firstLineFlag) {
                resultList.add(str);
            }
            else { // 2nd line check
                for (Character c:str.toLowerCase().toCharArray()) {
                    if (secondLine.indexOf(c) == -1) {
                        secondLineFlag = false;
                        break;
                    }
                }

                if (secondLineFlag) {
                    resultList.add(str);
                }
                else { // 3rd line check.
                    for (Character c:str.toLowerCase().toCharArray()) {
                        if (thirdLine.indexOf(c) == -1) {
                            thrirdLineFlag = false;
                            break;
                        }
                    }

                    if (thrirdLineFlag) {
                        resultList.add(str);
                    }
                }
            }


        }

        return resultList.toArray(new String[]{});
    }

}
