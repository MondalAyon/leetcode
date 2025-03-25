/*
https://leetcode.com/problems/design-compressed-string-iterator/submissions/1585108354/
https://leetcode.com/problems/design-compressed-string-iterator/description/
Design and implement a data structure for a compressed string iterator. The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

Implement the StringIterator class:

next() Returns the next character if the original string still has uncompressed characters, otherwise returns a white space.
hasNext() Returns true if there is any letter needs to be uncompressed in the original string, otherwise returns false.


Example 1:

Input
["StringIterator", "next", "next", "next", "next", "next", "next", "hasNext", "next", "hasNext"]
[["L1e2t1C1o1d1e1"], [], [], [], [], [], [], [], [], []]
Output
[null, "L", "e", "e", "t", "C", "o", true, "d", true]

Explanation
StringIterator stringIterator = new StringIterator("L1e2t1C1o1d1e1");
stringIterator.next(); // return "L"
stringIterator.next(); // return "e"
stringIterator.next(); // return "e"
stringIterator.next(); // return "t"
stringIterator.next(); // return "C"
stringIterator.next(); // return "o"
stringIterator.hasNext(); // return True
stringIterator.next(); // return "d"
stringIterator.hasNext(); // return True


Constraints:

1 <= compressedString.length <= 1000
compressedString consists of lower-case an upper-case English letters and digits.
The number of a single character repetitions in compressedString is in the range [1, 10^9]
At most 100 calls will be made to next and hasNext.
 */

import java.util.*;

public class StringIteratorV2 {

    Queue<HashMap<Character, Integer>> qmap;
    int x;
    //HashMap<Character, Integer> dict;

    public StringIteratorV2(String compressedString) {

        //dict = new LinkedHashMap<>();
        qmap = new LinkedList<>();
        x = 0;

        int i = 0;
        while (i<compressedString.length()) {

            char c = compressedString.charAt(i);
            i++;
            StringBuilder sb = new StringBuilder();

            while (i <compressedString.length() && Character.isDigit(compressedString.charAt(i))) {
                sb.append(compressedString.charAt(i));
                i++;
            }

            //dict.put(c, Integer.parseInt(sb.toString()));
            HashMap<Character, Integer> temp = new HashMap<>();
            temp.put(c, Integer.parseInt(sb.toString()));

            qmap.add(temp);
        }
    }

    public char next() {

        //char c = (char)dict.keySet().toArray()[0];
        //int n = (int)dict.values().toArray()[0];

        HashMap<Character, Integer> map = new HashMap<>();
        char c = ' ';

        if (!qmap.isEmpty()) {
            map = qmap.peek();
        }
        else return ' ';

        c = (char)map.keySet().toArray()[0];

        if (x == 0) {
            x = map.get(c);
        }

        x--;

        if (x == 0) {
            qmap.remove();
        }

        return c;
    }

    public boolean hasNext() {
        return (!qmap.isEmpty());
    }

    public static void main(String[] args) {

        //String compressedString = "A2B12C1";
        //String compressedString = "L1e2t1C1o1d1e1";
        String compressedString = "x6";

        StringIteratorV2 obj = new StringIteratorV2(compressedString);

        System.out.println(obj.qmap);

        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());




    }
}
