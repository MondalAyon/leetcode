/* https://leetcode.com/problems/my-calendar-i/description/
https://leetcode.com/problems/my-calendar-i/submissions/1451315056/

You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers startTime and endTime that represents a booking on the half-open interval [startTime, endTime), the range of real numbers x such that startTime <= x < endTime.

Implement the MyCalendar class:

MyCalendar() Initializes the calendar object.
boolean book(int startTime, int endTime) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.


Example 1:

Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]

Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
 */


/*
=========
Algorithm
=========

We will maintain a list of interval events (not necessarily sorted).
Evidently, two events [s1, e1) and [s2, e2) do not conflict if and only if one of them starts after the other one ends:
either e1 <= s2 OR e2 <= s1. By De Morgan's laws, this means the events conflict when s1 < e2 AND s2 < e1.
 */

import java.util.ArrayList;
import java.util.List;
public class MyCalender_I {

    List<Integer[]> calender;
    public MyCalender_I() {
        calender = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {

        if (calender.size() == 0) {
            calender.add(new Integer[]{startTime, endTime});
            return true;
        }
        for (Integer[] schedule:calender) {
            if (schedule[0] < endTime && startTime < schedule[1]) {
                return false;
            }
        }
        calender.add(new Integer[]{startTime, endTime});
        return true;
    }

    public static void main(String[] args) {

        MyCalender_I obj = new MyCalender_I();

        System.out.println(obj.book(10,20));
        System.out.println(obj.book(15,25));
        System.out.println(obj.book(20,30));


    }
}
