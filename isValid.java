/*
https://leetcode.com/problems/valid-parentheses/description/
https://leetcode.com/problems/valid-parentheses/submissions/1451091543/

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true



Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

 */
import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        //String s = "[{(){}[(())]}]";
        String s = ")";

        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (Character c:s.toCharArray()) {

            if (c == '[' || c == '{' || c == '(') {
                st.push(c);
            }
            else if ((st.size() != 0) && ((c == ')' && st.peek() == '(') || (c == '}' && st.peek() == '{') || (c == ']' && st.peek() == '['))) {
                      st.pop();
            }
            else
                return false;
        }

        return (st.size() == 0);
    }
}
