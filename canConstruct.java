/*
https://leetcode.com/problems/ransom-note/submissions/1397565101/
https://leetcode.com/problems/ransom-note/description/
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.
Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 */
import java.util.HashMap;

public class canConstruct {
    public static void main(String[] args) {
        String ransomNote = "aabbb";
        String magazine = "abbbbbccd";

        System.out.println(canConstruct(ransomNote, magazine));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> nMap = new HashMap<>();
        HashMap<Character, Integer> mMap = new HashMap<>();

        for (int i=0; i<ransomNote.length(); i++) {
            nMap.put(ransomNote.charAt(i), nMap.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }

        for (int i=0; i<magazine.length(); i++) {
            mMap.put(magazine.charAt(i), mMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        // Iterate through the ransomNote Map, i.e. nMap

        for (Character c: nMap.keySet()) {
            int n = mMap.getOrDefault(c, 0);
            if (n == 0 || n < nMap.get(c))
                return false;
        }

        return true;

    }
}
