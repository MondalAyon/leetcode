/*
https://leetcode.com/problems/largest-triangle-area/submissions/1603264276/
https://leetcode.com/problems/largest-triangle-area/description/
Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.



Example 1:


Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
Output: 2.00000
Explanation: The five points are shown in the above figure. The red triangle is the largest.
Example 2:

Input: points = [[1,0],[0,0],[0,1]]
Output: 0.50000


Constraints:

3 <= points.length <= 50
-50 <= xi, yi <= 50
All the given points are unique.
 */
public class largestTriangleArea {
    public static void main(String[] args) {
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};

        System.out.println(largestTriangleArea(points));
    }

    public static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs( x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2));
    }

    public static double largestTriangleArea(int[][] points) {

        double result = 0.0;

        for (int i=0; i< points.length; i++) {
            for (int j=i; j<points.length; j++) {
                for (int k=j; k<points.length; k++) {
                    result = Math.max(result, area(points[i][0], points[i][1]
                                                   ,points[j][0], points[j][1]
                                                   ,points[k][0], points[k][1]
                                                   ));
                }
            }
        }
        return result;
    }
}
