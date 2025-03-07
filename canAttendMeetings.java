/*
https://leetcode.com/problems/meeting-rooms/description/
https://leetcode.com/problems/meeting-rooms/submissions/1565549964/
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true


Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti < endi <= 106
 */
public class canAttendMeetings {
    public static void main(String[] args) {
        //int[][] intervals = {{0,30},{5,10},{15,20}};
        //int[][] intervals = {{7,10},{2,4}};
        int[][] intervals = {{8,11},{17,20},{17,20}};

        System.out.println(canAttendMeetings(intervals));

    }

    public static boolean canAttendMeetings(int[][] intervals) {

        for (int i=0; i< intervals.length; i++) {
            for (int j=0; j<intervals.length; j++) {

                if ((i != j) && (intervals[i][0] > intervals[j][0] && intervals[i][0] < intervals[j][1])) {
                    return false;
                }
                if ((i != j) && (intervals[i][0] == intervals[j][0] || intervals[i][1] == intervals[j][1])) {
                    return false;
                }

            }
        }
        return true;
    }
}
