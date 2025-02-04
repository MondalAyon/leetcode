/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
https://leetcode.com/problems/letter-combinations-of-a-phone-number/solutions/6371084/simple-bruteforce-without-backtracking-b-aga3/
https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/1530553846/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class letterCombinations {

    public static void main(String[] args) {
        String digits = "2345";

        System.out.println(letterCombinations(digits));

    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));

        for (Character c: digits.toCharArray()) {

            List<String> tempResult = new ArrayList<>();

            if (Integer.parseInt(c.toString()) >= 2 && Integer.parseInt(c.toString()) <= 9) {

                if (result.size() == 0) {
                    for (int i = 0; i < map.get(c).size(); i++) {
                        result.add(map.get(c).get(i).toString());
                    }
                }

                else if (result.size() != 0) {

                    for (int j=0; j<result.size(); j++) {

                        for (int k=0; k<map.get(c).size(); k++) {
                          tempResult.add(result.get(j) + map.get(c).get(k).toString());
                        }
                    }

                    // Remove all existing elements of "result"
                    result.clear();

                    // Add all elements of tempResult into result and remove from tempResult
                    result.addAll(tempResult);
                }
            }
        }

        return result;
    }
}
