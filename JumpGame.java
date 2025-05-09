/* https://leetcode.com/problems/jump-game-ii/description/

 */
public class JumpGame {

    //private int n;
    //private int steps;

    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};

        System.out.println(jump(nums));

        //JumpGame obj = new JumpGame();

        //System.out.println(obj.jump(nums));

    }


    public static int jump(int[] nums) {

        int ans = 0;
        int ce = 0;
        int cf = 0;

        for (int i=0; i< nums.length - 1; i++) {

            cf = Math.max(cf, i+nums[i]);

            if (cf == nums.length - 1) {
                return ++ans;
            }

            if (i == ce) {
                ans++;
                ce = cf;
            }
        }
        return ans;
    }

    /*
    public int jump(int[] nums) {

        int s = 0;
        n = nums.length;

        if (nums.length == 1 || nums.length == 0) return nums.length;

        s = makeJump(0, 1, nums);

        return s;
    }

    private int makeJump(int currentPos, int steps, int[] nums) {

        if (currentPos >= n) return steps;
        if (currentPos == n - 1) return steps;

        steps++;

        for (int i=0; i<=nums[currentPos]; i++) {

            int newPos = currentPos + i;
            if (newPos == n-1) return steps;

            if (currentPos != newPos) {
                makeJump(newPos, steps, nums);
            }
        }

        return steps;

    }
    */
}
