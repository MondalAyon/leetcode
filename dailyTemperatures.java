/*
https://leetcode.com/problems/daily-temperatures/submissions/1419766918/
https://leetcode.com/problems/daily-temperatures/description/
Given an array of integers temperatures represents the daily temperatures, return an array answer such that
answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 */
import java.util.Arrays;
import java.util.Stack;

public class dailyTemperatures {
    public static void main(String[] args) {

        int[] temperatures = {73,74,75,71,69,72,76,73};

        //System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperaturesV2(temperatures)));
    }


    /* Using stack. O(n+n) => O(n). Memory: O(n) */
    /* Algorithm:

    int[] result, initialize with zeros.
    Stack of Int. Initialize with "0" as one item for the first day. Stack item is the "dayToUpdate" in the result Array.
    int i -> is the pointer for the input "temperatures" array. Initialize it to 1

    if (temperatures[i] > temperatures[jD or the stack pointer]
        update the result array -
            1. for all item in the stack
            2. if the temp[i] > temp[stack top day]
                  result[stack top day] = i - stack top day
                  pop the stack
               else
                  break the loop in #2
    otherwise
        push next days pointer to the stack

     */

    public static int[] dailyTemperaturesV2(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Arrays.fill(result,0);

        Stack<Integer> st = new Stack<>();
        st.push(0);

        int jD=0; // Days pointer.

        for (int i=1; i<temperatures.length; i++) {

            if (temperatures[i] > temperatures[jD]) {

                while (!st.isEmpty()) {

                    int dayToUpdate = st.peek();

                    if (temperatures[i] > temperatures[dayToUpdate]) {
                        result[dayToUpdate] = i - dayToUpdate;
                        st.pop();
                    }
                    else break;
                }
            }

            st.push(++jD);
        }

        return result;
    }


    /* Works but time limit exceeds due to runtime O(n^2) */

    public static int[] dailyTemperatures(int[] temperatures) {

        int L = temperatures.length;
        int[] result = new int[L];
        boolean found = false;

        Arrays.fill(result,0);

        for (int i = 0; i<L; i++) {

            int dayCount = 0;
            found = false;

            for (int j = i+1; j<L; j++) {

                if (temperatures[i] < temperatures[j]) {
                    dayCount++;
                    found = true;
                    break;
                }
                else {
                    dayCount++;
                }
            }
            if (found == false) dayCount = 0;
            result[i] = dayCount;
        }

        return result;
    }
}
