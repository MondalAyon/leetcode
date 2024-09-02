/*
https://leetcode.com/problems/container-with-most-water/description/
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 */

public class maxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        //int[] height = {1,1};

        System.out.println("Max Area: " + maxAreaV2(height));
    }

    public static int maxAreaV2(int[] height) {
        
        /* This V2 is based on solution here - https://leetcode.com/problems/container-with-most-water/solutions/5139915/video-simple-two-pointer-solution/
        This runs on O(n) and hence doesn't time limit exceeds.
         */

        int maxArea = Integer.MIN_VALUE;
        int a = 0;
        int b = 0;

        int leftP = 0;
        int rightP = height.length - 1;

        while (rightP > leftP) {

                int cb = Integer.min(height[leftP], height[rightP]);
                int d = rightP - leftP;
                int A = cb * d;

                maxArea = Math.max(A, maxArea);

                if (height[leftP] < height[rightP]) {
                    leftP++;
                } else {
                    rightP--;
                }
            }
        System.out.println("Point a=" + a + " Point b=" + b);
        return maxArea;
    }

    public static int maxArea(int[] height) {
        
        /*
         This works but Time limit exceeds due to O(n^2) complexity. 
         */

        int maxArea = Integer.MIN_VALUE;
        int a = 0;
        int b = 0;

        for (int i=0; i<height.length; i++) {
            for (int j=i+1; j<height.length; j++) {

                int cb = Integer.min(height[i], height[j]);
                int d = j-i;
                int A = cb * d;

                if (A > maxArea) {
                    maxArea = A;
                    a = height[i];
                    b = height[j];
                }
            }
        }
        System.out.println("Point a=" + a + " Point b=" + b);
        return maxArea;
    }
}
