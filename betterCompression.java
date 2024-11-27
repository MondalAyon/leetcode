/*
https://leetcode.com/problems/better-compression-of-string/
https://leetcode.com/problems/better-compression-of-string/submissions/1463825168/

You are given a string compressed representing a compressed version of a string. The format is a character followed by its frequency. For example, "a3b1a1c2" is a compressed version of the string "aaabacc".

We seek a better compression with the following conditions:

Each character should appear only once in the compressed version.
The characters should be in alphabetical order.
Return the better compression of compressed.

Note: In the better version of compression, the order of letters may change, which is acceptable.



Example 1:

Input: compressed = "a3c9b2c1"

Output: "a3b2c10"

Explanation:

Characters "a" and "b" appear only once in the input, but "c" appears twice, once with a size of 9 and once with a size of 1.

Hence, in the resulting string, it should have a size of 10.

Example 2:

Input: compressed = "c2b3a1"

Output: "a1b3c2"

Example 3:

Input: compressed = "a2b4c1"

Output: "a2b4c1"



Constraints:

1 <= compressed.length <= 6 * 104
compressed consists only of lowercase English letters and digits.
compressed is a valid compression, i.e., each character is followed by its frequency.
Frequencies are in the range [1, 104] and have no leading zeroes.

 */
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class betterCompression {
    public static void main(String[] args) {
        String compressed = "c2b3a1";

        System.out.println(betterCompression(compressed));
    }

    public static String betterCompression(String compressed) {

        String resultStr = "";
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getKey().compareTo(b.getKey())
        );

        String strVal = "";
        Character prevChar = null;

        for (Character c:compressed.toCharArray()) {

            if (Character.isLetter(c)) {

                if (prevChar != null) {
                    map.put(prevChar, map.getOrDefault(prevChar,0) + Integer.valueOf(strVal));
                }
                strVal = "";
                prevChar = c;
            }
            else {
                strVal += c.toString();
            }
        }
        map.put(prevChar, map.getOrDefault(prevChar,0) + Integer.valueOf(strVal));

        //System.out.println(map);

        for (Map.Entry<Character, Integer> entry:map.entrySet()) {
            pq.add(entry);
        }

        while (!pq.isEmpty()) {
            resultStr += pq.poll();

        }

        resultStr = resultStr.replaceAll("=", "");
        return resultStr;
    }
}
