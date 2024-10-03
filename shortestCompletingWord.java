/*
https://leetcode.com/problems/shortest-completing-word/
https://leetcode.com/problems/shortest-completing-word/submissions/
Given a string licensePlate and an array of strings words, find the shortest completing word in words.

A completing word is a word that contains all the letters in licensePlate. Ignore numbers and spaces in licensePlate, and treat letters as case insensitive. If a letter appears more than once in licensePlate, then it must appear in the word the same number of times or more.

For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice. Possible completing words are "abccdef", "caaacab", and "cbca".

Return the shortest completing word in words. It is guaranteed an answer exists. If there are multiple shortest completing words, return the first one that occurs in words.

Example 1:

Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
Output: "steps"
Explanation: licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.
"step" contains 't' and 'p', but only contains 1 's'.
"steps" contains 't', 'p', and both 's' characters.
"stripe" is missing an 's'.
"stepple" is missing an 's'.
Since "steps" is the only word containing all the letters, that is the answer.
Example 2:

Input: licensePlate = "1s3 456", words = ["looks","pest","stew","show"]
Output: "pest"
Explanation: licensePlate only contains the letter 's'. All the words contain 's', but among these "pest", "stew", and "show" are shortest. The answer is "pest" because it is the word that appears earliest of the 3.

 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class shortestCompletingWord {
    public static void main(String[] args) {
        String licensePlate  = "re69865";
        String[] words = {"population","crime","kid","pressure","store","any","relate","will","death","when"};
        //String[] words = {"according"};

        System.out.println(shortestCompletingWordV2(licensePlate, words));

    }

    public static String shortestCompletingWordV2(String licensePlate, String[] words) {

        HashMap<Character, Integer> lpMap = new HashMap<>();

        for (Character c: licensePlate.toLowerCase().toCharArray()) {
            if ((c >= 'a' && c<= 'z') || (c >= 'A' && c<= 'Z')) {
                lpMap.put(c, lpMap.getOrDefault(c, 0) + 1);
            }
        }


        String resultStr = "";
        int resultSize = Integer.MAX_VALUE;

        for (String word:words) {

            HashMap<Character, Integer> mapWord = new HashMap<>();
            boolean flag = true;

            for (Character c:word.toLowerCase().toCharArray()) {
                mapWord.put(c, mapWord.getOrDefault(c,0) + 1);
            }

            for (Character c:lpMap.keySet()) {
                if (!mapWord.containsKey(c) || !(mapWord.get(c) >= lpMap.get(c))) {
                    flag = false;
                    break;
                }
            }

            if (flag == true && word.length() < resultSize) {
                resultStr = word;
                resultSize = word.length();
            }

        }

        return resultStr;
    }

    /* This is not working since the priority Q is not ordered by occurance when there is tie up */
    /*
    public static String shortestCompletingWord(String licensePlate, String[] words) {

        HashMap<String, Integer> sizeMap = new LinkedHashMap<>();
        HashMap<Character, Integer> lpMap = new HashMap<>();

        for (String word: words) {
            sizeMap.put(word.toLowerCase(), word.length());
        }

        System.out.println("sizeMap: " + sizeMap);

        for (Character c: licensePlate.toLowerCase().toCharArray()) {
            if ((c >= 'a' && c<= 'z') || (c >= 'A' && c<= 'Z')) {
                lpMap.put(c, lpMap.getOrDefault(c, 0) + 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pqMap = new PriorityQueue<>(
                (a,b) -> a.getValue().compareTo(b.getValue())
        );

        for (Map.Entry<String, Integer> entry: sizeMap.entrySet()) {
            pqMap.add(entry);
        }

        while (!pqMap.isEmpty()) {
            String word = pqMap.poll().getKey();

            HashMap<Character, Integer> mapWord = new HashMap<>();
            boolean flag = true;

            for (Character c:word.toCharArray()) {
                mapWord.put(c, mapWord.getOrDefault(c,0) + 1);
            }

            for (Character c:lpMap.keySet()) {
                if (!mapWord.containsKey(c) || !(mapWord.get(c) >= lpMap.get(c))) {
                    flag = false;
                    break;
                }
            }

            if (flag == true) return word;
        }

        return "";
    }
    */
}
