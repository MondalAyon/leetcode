/*
https://leetcode.com/problems/pascals-triangle/solutions/6522473/simple-solution-with-inner-loop-by-ayonm-5it4/
https://leetcode.com/problems/pascals-triangle/description/
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]


Constraints:

1 <= numRows <= 30
 */
import java.util.ArrayList;
import java.util.List;

public class generate {
    public static void main(String[] args) {

        //System.out.println(generate(0));

        System.out.println(getRow(3));

    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> prevList = new ArrayList<>();

        for (int l=1; l<=numRows; l++) {

            List<Integer> nextList = new ArrayList<>();

            for (int i = 0; i < l; i++) {

                if (i == 0 || i == l-1) {
                    nextList.add(1);
                } else {
                    nextList.add(prevList.get(i-1) + prevList.get(i));
                }
            }

            resultList.add(nextList);
            prevList = nextList;

        }
        return resultList;
    }

    public static List<Integer> getRow(int rowIndex) {

        List<Integer> prevList = new ArrayList<>();

        rowIndex++;

        for (int l=1; l<=rowIndex; l++) {

            List<Integer> nextList = new ArrayList<>();

            for (int i = 0; i < l; i++) {

                if (i == 0 || i == l-1) {
                    nextList.add(1);
                } else {
                    nextList.add(prevList.get(i-1) + prevList.get(i));
                }
            }

            if (l == rowIndex) {
                return nextList;
            }
            prevList = nextList;

        }
        return new ArrayList<>();

    }
}
