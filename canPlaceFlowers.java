/*
https://leetcode.com/problems/can-place-flowers/submissions/1588755417/
https://leetcode.com/problems/can-place-flowers/description/

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.



Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false


Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
 */
public class canPlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = {0,0,0,0};
        int n = 3;

        System.out.println(canPlaceFlowers(flowerbed, n));

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n==0) {
            return true;
        }

        if (flowerbed.length < 3) {
            if (flowerbed.length == 0) {
                return false;
            }
            else if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) {
                return true;
            }
            else if (flowerbed.length == 2 && flowerbed[0] == 0 && flowerbed[1] == 0 && n == 1) {
                return true;
            }
            else return false;
        }

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            n--;

            if (n == 0) {
                return true;
            }
        }
        if (flowerbed[flowerbed.length-1] == 0 && flowerbed[flowerbed.length-2] == 0) {
            n--;

            if (n == 0) {
                return true;
            }
        }

        if (n == 0) {
            return true;
        }

        for (int i=2; i<flowerbed.length-2; i++) {
            if ((flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0)
                    //(i-1 == 0 && flowerbed[i-1] == 0 && flowerbed[i] == 0) || // [0,0,1,0,1]
                    //(i+1 == flowerbed.length-1 && flowerbed[i+1] == 0 && flowerbed[i] == 0)
                ) {
                n--;
                i++;
            }
            if (n == 0) {
                return true;
            }
        }
        return false;
    }

}


