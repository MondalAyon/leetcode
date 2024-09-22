/*
https://leetcode.com/problems/shuffle-an-array/submissions/1397910178/
https://leetcode.com/problems/shuffle-an-array/description/

Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.


Example 1:

Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 */

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class shuffleArray {
    private int[] nums = new int[]{};

    public shuffleArray(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {

        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        int [] resultArray = new int[this.nums.length];

        for (int i=0; i < this.nums.length; i++)
            list.add(this.nums[i]);

        int len = this.nums.length - 1;

        for (int i=0; i < this.nums.length; i++) {

            int r = random.nextInt(len+1);
            resultArray[i] = list.get(r);
            list.remove(r);
            len--;

        }

        //Arrays.stream(nums).forEach(System.out::print);
        return resultArray;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5};

        myUtility myUtilObj = new myUtility();

        System.out.println("Input array -");
        myUtilObj.printArray(nums);

        shuffleArray obj = new shuffleArray(nums);

        int[] param_1 = obj.reset();

        System.out.println("O/P of reset -");
        myUtilObj.printArray(param_1);

        int[] param_2 = obj.shuffle();
        System.out.println("O/P of shuffle - ");
        myUtilObj.printArray(param_2);

    }
}
