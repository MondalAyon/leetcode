/*
https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/description/
https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/submissions/1463855141/
https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/solutions/6087327/very-simple-and-easy-solution-beats-100/

You are given a string s. Simulate events at each second i:

If s[i] == 'E', a person enters the waiting room and takes one of the chairs in it.
If s[i] == 'L', a person leaves the waiting room, freeing up a chair.
Return the minimum number of chairs needed so that a chair is available for every person who enters the waiting room given that it is initially empty.

 */
public class minimumChairs {
    public static void main(String[] args) {
        String s = "EEEEEEE";

        System.out.println(minimumChairs(s));

    }

    public static int minimumChairs(String s) {

        int resultMax = Integer.MIN_VALUE;
        int eCounter = 0;

        for (Character c:s.toCharArray()) {

            if (c == 'E') {
                eCounter++;
                if (eCounter > resultMax) {
                    resultMax = eCounter;
                }
            }
            else
                eCounter--;
        }
        return resultMax;
    }
}
