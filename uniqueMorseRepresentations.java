/*
https://leetcode.com/problems/unique-morse-code-words/description/
https://leetcode.com/problems/unique-morse-code-words/submissions/1445286115/
International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:

'a' maps to ".-",
'b' maps to "-...",
'c' maps to "-.-.", and so on.
For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
Return the number of different transformations among all words we have.

 

Example 1:

Input: words = ["gin","zen","gig","msg"]
Output: 2
Explanation: The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."
There are 2 different transformations: "--...-." and "--...--.".
Example 2:

Input: words = ["a"]
Output: 1
 */
import java.util.HashMap;
import java.util.HashSet;

public class uniqueMorseRepresentations {
    public static void main(String[] args) {

        String[] words = {"gin","zen","gig","msg"};

        System.out.println(uniqueMorseRepresentations(words));

    }

    public static int uniqueMorseRepresentations(String[] words) {

        HashSet<String> codeSet = new HashSet<>();

        if (words.length == 0 || words.length == 1) return words.length;

        for (String word: words) {

            StringBuilder sb = new StringBuilder();

            for (Character c:word.toCharArray()) {
                sb.append(toMorseCode(c));
            }

            codeSet.add(sb.toString());
        }

        return codeSet.size();
    }

    private static String toMorseCode(Character c) {
        HashMap<Character, String> morseMap = new HashMap<>();

        morseMap.put('a',".-");
        morseMap.put('b',"-...");
        morseMap.put('c',"-.-.");
        morseMap.put('d',"-..");
        morseMap.put('e',".");
        morseMap.put('f',"..-.");
        morseMap.put('g',"--.");
        morseMap.put('h',"....");
        morseMap.put('i',"..");
        morseMap.put('j',".---");
        morseMap.put('k',"-.-");
        morseMap.put('l',".-..");
        morseMap.put('m',"--");
        morseMap.put('n',"-.");
        morseMap.put('o',"---");
        morseMap.put('p',".--.");
        morseMap.put('q',"--.-");
        morseMap.put('r',".-.");
        morseMap.put('s',"...");
        morseMap.put('t',"-");
        morseMap.put('u',"..-");
        morseMap.put('v',"...-");
        morseMap.put('w',".--");
        morseMap.put('x',"-..-");
        morseMap.put('y',"-.--");
        morseMap.put('z',"--..");

        if (morseMap.containsKey(c)) {
            return morseMap.get(c);
        }
        else return null;
    }
}
