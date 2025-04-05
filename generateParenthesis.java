/*
https://leetcode.com/problems/generate-parentheses/description/
https://leetcode.com/problems/generate-parentheses/submissions/1597624002/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class generateParenthesis {
    public static void main(String[] args) {

        int n = 1;

        System.out.println(generateParenthesis(n));

        //System.out.println(isValid("(()(()))"));


    }

    public static List<String> generateParenthesis(int n) {

        //Queue<String> queue = new LinkedList<>(Arrays.asList(""));
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        queue.add("");

        while (true) {

            String temp = queue.poll();

            if (temp.length() == 2*n) {

                while (!queue.isEmpty()) {

                    String s = queue.remove();
                    if (isValid(s)) {
                        result.add(s);
                    }
                }
                return result;
            }
            queue.offer(temp + "(");
            queue.offer(temp + ")");
        }

    }

    public static boolean isValid(String str) {

        int left = 0;

        for (Character c:str.toCharArray()) {
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                if (left == 0) {
                    return false;
                }
                else {
                    left--;
                }
            }
        }

        return (left == 0);
    }


}
