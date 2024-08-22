/*
https://leetcode.com/problems/repeated-dna-sequences/description/
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
You may return the answer in any order.

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 */

import java.util.*;
import java.util.HashMap;

public class findRepeatedDnaSequences {
    public static void main(String[] args) {
        //String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s = "AAAAAAAAAAAAA";
        //String s = "AAAAAAAAAAA";
        System.out.println(s.length());

        //System.out.println(findRepeatedDnaSequences(s));

        //System.out.println(findRepeatedDnaSequencesv2(s));

        System.out.println(findRepeatedDnaSequencesv3(s));
    }

    public static List<String> findRepeatedDnaSequencesv3(String s) {

        /* Faster Solution using Hashmap.
        Runs one loop only (i.e. runtime O(n)) and generates all possible substring and store them into HashMap.
        Then scan the Hashmap for values > 1, if yes then those are the repeated substrings. Return distinct of them.
         */

        HashMap<String, Integer> subStringSet = new HashMap<>();
        List<String> resultList = new ArrayList<>();

        for (int i=0; i<s.length()-9; i++) {
            String subStr = s.substring(i, i+10);
            if (subStringSet.containsKey(subStr)) {
                int value = subStringSet.get(subStr);
                subStringSet.put(subStr, ++value);
            }
            else {
                subStringSet.put(subStr, 1);
            }
        }
        //System.out.println(subStringSet);
        for (String str:subStringSet.keySet()) {
            if (subStringSet.get(str) > 1) {
                resultList.add(str);
            }
        }
        return resultList;
    }

    public static List<String> findRepeatedDnaSequencesv2(String s) {
        /* This is one thebest solution, collected from Internet
         */

        Set seen = new HashSet();
        Set repeated = new HashSet();

        for (int i=0; i+9 <s.length(); i++) {
            //System.out.print(i + " ");
            String subStr = s.substring(i, i+10);
            //System.out.println(subStr);

            if (!seen.add(subStr)) {
                repeated.add(subStr);
            }
        }


        return new ArrayList(repeated);
    }

    public static List<String> findRepeatedDnaSequences(String s) {

        /* This one use two loops, works, but high runtime complexity
         */
        List<String> resultList = new ArrayList<>();
        HashSet<String> resultHashset = new HashSet<>();

        String subStr1 = "";
        String subStr2 = "";


        for (int i=0; i<s.length()-10; i++) {

            subStr1 = s.substring(i,i+10);

            for (int j=i+1; j<=s.length()-10; j++) {

                subStr2 = s.substring(j, j+10);

                if (subStr1.equals(subStr2)) {
                    //resultList.add(subStr1);
                    resultHashset.add(subStr1);
                }
            }
        }

        System.out.println("resultHashset: " + resultHashset);
        for (String str: resultHashset) {
            resultList.add(str);
        }

        return resultList;
    }
}
