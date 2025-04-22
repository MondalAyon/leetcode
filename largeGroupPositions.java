/* https://leetcode.com/problems/positions-of-large-groups/description/
https://leetcode.com/problems/positions-of-large-groups/submissions/1610994165/

In a string s of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".

A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].

A group is considered large if it has 3 or more characters.

Return the intervals of every large group sorted in increasing order by start index.



Example 1:

Input: s = "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the only large group with start index 3 and end index 6.
Example 2:

Input: s = "abc"
Output: []
Explanation: We have groups "a", "b", and "c", none of which are large groups.
Example 3:

Input: s = "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
Explanation: The large groups are "ddd", "eeee", and "bbb".


Constraints:

1 <= s.length <= 1000
s contains lowercase English letters only.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
106.8K
Submissions
202.2K
Acceptance Rate
52.8%
 */
import java.util.ArrayList;
import java.util.List;

public class largeGroupPositions {
    public static void main(String[] args) {
        String s = "aaa";

        System.out.println(largeGroupPositions(s));


    }

    public static List<List<Integer>> largeGroupPositions(String s) {

        int cnt = 1;
        int sIdx = 0;
        int eIdx = 0;

        List<List<Integer>> resultList = new ArrayList<>();

        for (int i=1; i<s.length(); i++) {

            if (s.charAt(i-1) == s.charAt(i)) {
                if (cnt == 1) {
                    sIdx = i-1;
                }
                cnt++;
            }
            else {
                if (cnt >= 3) {
                    eIdx = i-1;

                    List<Integer> temp = new ArrayList<>();

                    temp.add(sIdx);
                    temp.add(eIdx);

                    resultList.add(temp);
                    //cnt = 1;
                }
                cnt = 1;
            }
        }

        if (cnt>=3) {
            eIdx = s.length()-1;

            List<Integer> temp = new ArrayList<>();

            temp.add(sIdx);
            temp.add(eIdx);

            resultList.add(temp);

        }

        return resultList;

    }

}
