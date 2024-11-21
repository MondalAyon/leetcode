/*
https://leetcode.com/problems/alternating-groups-ii/submissions/1459563568/
https://leetcode.com/problems/alternating-groups-ii/description/
There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:

colors[i] == 0 means that tile i is red.
colors[i] == 1 means that tile i is blue.
An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).

Return the number of alternating groups.

Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.



Example 1:

Input: colors = [0,1,0,1,0], k = 3

Output: 3

Explanation:



Alternating groups:



Example 2:

Input: colors = [0,1,0,0,1,0,1], k = 6

Output: 2

Explanation:



Alternating groups:



Example 3:

Input: colors = [1,1,0,1], k = 4

Output: 0

Explanation:





Constraints:

3 <= colors.length <= 105
0 <= colors[i] <= 1
3 <= k <= colors.length
 */

public class numberOfAlternatingGroupsII {
    public static void main(String[] args) {

        int[] colors = {0,1,0,0,1};
        int k = 3;

        System.out.println(numberOfAlternatingGroupsV3(colors, k));


    }

    public static int numberOfAlternatingGroupsV3(int[] colors, int k) {
        int len = colors.length;
        int[] newColors = new int[len + k - 1];
        int groupCount = 0;

        for (int i=0; i<len + k - 1; i++)
            newColors[i] = colors[i % len];

        for (int i=0; i<newColors.length-1; i++) {

            int lo = i;
            int up = (i + 1);
            int count = 1;

            while ((up < newColors.length) && (newColors[lo] != newColors[up])) {
                lo++;
                up++;
                count++;
            }

            i = lo;
            if (count >= k) {
                groupCount += count - k + 1;
                //break;
            }

        }

        return groupCount;
    }

    /* Works but time limit exceeds dut to O(n^n) comlexity */

    public static int numberOfAlternatingGroups(int[] colors, int k) {

        int len = colors.length;
        int groupCount = 0;

        for (int i=0; i<colors.length; i++) {

            int j = i;
            int l = (i + 1) % len;
            int K = k - 1;
            boolean groupFound = true;

            while (K > 0) {
                if (colors[j] != colors[l]) {
                    j = (j + 1) % len;
                    l = (l + 1) % len;
                    K--;
                }
                else {
                    groupFound = false;
                    break;
                }
            }

            if (groupFound)
                groupCount++;
        }
        return groupCount;
    }
}
