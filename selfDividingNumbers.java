/*
https://leetcode.com/problems/self-dividing-numbers/solutions/5984681/simple-and-easy-to-understand-solution/
https://leetcode.com/problems/self-dividing-numbers/submissions/
https://leetcode.com/problems/self-dividing-numbers/description/
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
A self-dividing number is not allowed to contain the digit zero.

Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right] (both inclusive).



Example 1:

Input: left = 1, right = 22
Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
Example 2:

Input: left = 47, right = 85
Output: [48,55,66,77]
 */

import java.util.ArrayList;
import java.util.List;

public class selfDividingNumbers {
    public static void main(String[] args) {
        int left = 66;
        int right = 708;

        System.out.println(selfDividingNumbers(left, right));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> resultList = new ArrayList<>();

        for (int n = left; n <= right; n++) {
            System.out.println("n= " + n);

            if (n%10 == 0) {
                continue;
            }

            String str = Integer.toString(n);
            boolean selfDividing = true;

            if (str.contains("0")) {
                continue;
            }

            for (Character c : str.toCharArray()) {
                //System.out.println(c);

                if (n % Integer.parseInt(c.toString()) != 0) {
                    selfDividing = false;
                    break;
                }
            }

            if (selfDividing) {
                resultList.add(n);
            }
        }

        return resultList;
    }
}
