/* https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findDisappearedNumbers {
    public static void main(String[] args) {

        //int[] nums = {4,3,2,7,8,2,3,1};

        int[] nums = {1,1,1,1};

        System.out.println(findDisappearedNumbers2(nums));

    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {

        List<Integer> resultList = new ArrayList<>();
        int len = nums.length;
        int j = 0;

        Arrays.sort(nums);

        for (int i=1; i<=len; i++) {

            while (j<len && nums[j] < i) {
                j++;
            }

            if (j<len && nums[j] == i) {
                j++;
                continue;
            }

            //while (nums[j] < i) {
            //    j++;
            //}

            if (j<len && nums[j] > i) {
                resultList.add(i);
            }

            if (j>=len) {
                resultList.add(i);
            }

        }

        return resultList;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> resultList = new ArrayList<>();
        int len = nums.length;
        int n = 1;

        Arrays.sort(nums);

        for (int i=0; i<len; i++) {

            if (nums[i] == n) {
                n++;
            }
            else {
                if (nums[i] > n) {
                    resultList.add(n);
                    n++;
                }
            }
        }

        for (int j=n; j<=len; j++) {
            resultList.add(j);
        }

        return resultList;
    }

}
