/*
https://leetcode.com/problems/group-anagrams/description/
https://leetcode.com/problems/group-anagrams/submissions/1533128095/

Given an array of strings strs, group the
anagrams
 together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]



Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
import java.util.*;

public class groupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        //String[] strs = {"",""};
        //System.out.println(groupAnagrams(strs));

        //System.out.println(isAnagram("eat","taa"));
        //System.out.println(isAnagram3("eat","tta"));

        System.out.println(groupAnagramsV2(strs));
    }

    /* Using sort */
    public static boolean isAnagram3(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        Arrays.sort(sa);
        Arrays.sort(ta);

        String stra = new String(sa);
        String strt = new String(ta);

        //System.out.println(stra);
        //System.out.println(strt);

        return (stra.equals(strt));
    }

    /* using Hashmap */
    public static boolean isAnagram(String s, String t) {

        HashMap<Character,Integer> maps = new HashMap<>();
        HashMap<Character,Integer> mapt = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i=0; i<s.length(); i++) {

            maps.put(s.charAt(i), maps.getOrDefault(s.charAt(i),0) + 1);
            mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i),0) + 1);
        }

        //System.out.println("maps:" + maps);
        //System.out.println("mapt:" + mapt);

        return (maps.equals(mapt));
    }

    /* O(N*M*LogM) */
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Set<Integer> taken = new HashSet<>();

        for (int i = 0; i<strs.length; i++) {

            if (!taken.contains(i)) {

                List<String> rstr = new ArrayList<>();
                taken.add(i);
                rstr.add(strs[i]);

                for (int j = i + 1; j < strs.length; j++) {

                    if (!taken.contains(j)) {

                        if (isAnagram3(strs[i], strs[j])) {
                            taken.add(j);
                            rstr.add(strs[j]);
                        }
                    }
                }
                result.add(rstr);
            }
        }
        return result;
    }

    /* O(N∗KLogK) : Without Anagram check*/
    public static List<List<String>> groupAnagramsV2(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<Integer>> map = new HashMap<>();

        for (int i=0; i<strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);

            String sortedStr = new String(temp);

            List<Integer> templist = new ArrayList<>();

            if (map.containsKey(sortedStr)) {
                templist = map.get(sortedStr);
            }
            templist.add(i);
            map.put(sortedStr, templist);
        }

        for (String s:map.keySet()) {
            List<String> tStringList = new ArrayList<>();

            for (Integer idx:map.get(s)) {
                tStringList.add(strs[idx]);
            }

            result.add(tStringList);
        }
        return result;
    }
}
