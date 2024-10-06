/*
https://leetcode.com/problems/goat-latin/submissions/1414165076/
https://leetcode.com/problems/goat-latin/description/
You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:

If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
For example, the word "apple" becomes "applema".
If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
Return the final sentence representing the conversion from sentence to Goat Latin.

Example 1:

Input: sentence = "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: sentence = "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */

public class goatLatin {
    public static void main(String[] args) {
        String sentence = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(sentence));
    }

    public static String toGoatLatin(String sentence) {

        String resultStr = "";
        int wordCount = 0;
        String aStr = "";

        for (String str:sentence.split("\\s+")) {

            wordCount++;

            aStr = "";
            for (int j=0; j<wordCount; j++) {
                aStr += "a";
            }

            if (str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u' ||
                str.charAt(0) == 'A' || str.charAt(0) == 'E' || str.charAt(0) == 'I' || str.charAt(0) == 'O' || str.charAt(0) == 'U' ) {
                str += "ma";

                resultStr += str + aStr + " ";
            }
            else { // i.e. starts with a consonant
                String s = str.substring(1,str.length()) + str.charAt(0) + "ma";
                resultStr += s + aStr + " ";
            }
        }
        return resultStr.trim();
    }

}
