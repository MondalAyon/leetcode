/*
https://leetcode.com/problems/sentence-similarity/
https://leetcode.com/problems/sentence-similarity/submissions/1411084326/
We can represent a sentence as an array of words, for example, the sentence "I am happy with leetcode" can be represented as arr = ["I","am",happy","with","leetcode"].

Given two sentences sentence1 and sentence2 each represented as a string array and given an array of string pairs similarPairs where similarPairs[i] = [xi, yi] indicates that the two words xi and yi are similar.

Return true if sentence1 and sentence2 are similar, or false if they are not similar.

Two sentences are similar if:

They have the same length (i.e., the same number of words)
sentence1[i] and sentence2[i] are similar.
Notice that a word is always similar to itself, also notice that the similarity relation is not transitive. For example, if the words a and b are similar, and the words b and c are similar, a and c are not necessarily similar.

Example 1:

Input: sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama","talent"], similarPairs = [["great","fine"],["drama","acting"],["skills","talent"]]
Output: true
Explanation: The two sentences have the same length and each word i of sentence1 is also similar to the corresponding word in sentence2.
Example 2:

Input: sentence1 = ["great"], sentence2 = ["great"], similarPairs = []
Output: true
Explanation: A word is similar to itself.
Example 3:

Input: sentence1 = ["great"], sentence2 = ["doubleplus","good"], similarPairs = [["great","doubleplus"]]
Output: false
Explanation: As they don't have the same length, we return false.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class areSentencesSimilar {
    public static void main(String[] args) {

        /*
        String[] sentence1 = {"great","acting","skills"};
        String[] sentence2 = {"fine","drama","talent"};
        List<List<String>> similarPairs = new ArrayList<>();

        similarPairs.add(Arrays.asList("great","fine"));
        similarPairs.add(Arrays.asList("drama","acting"));
        similarPairs.add(Arrays.asList("skills","talent"));
         */

        String[] sentence1 = {"great"};
        String[] sentence2 = {"doubleplus","good"};

        List<List<String>> similarPairs = new ArrayList<>();
        similarPairs.add(Arrays.asList("great", "doubleplus"));


        System.out.println(areSentencesSimilar(sentence1, sentence2, similarPairs));

    }

    public static boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

        int i = 0;

        if (sentence1.length == sentence2.length) {

            for (String str1:sentence1) {

                if (!str1.equals(sentence2[i])) {

                    List<String> list = new ArrayList<>();
                    list.add(str1);
                    list.add(sentence2[i]);

                    List<String> listReversed = new ArrayList<>();
                    listReversed.add(sentence2[i]);
                    listReversed.add(str1);

                    if (!similarPairs.contains(list) && !similarPairs.contains(listReversed)) {
                        return false;
                    }
                }

                i++;
            }
            return true;
        }

        return false;
    }
}
