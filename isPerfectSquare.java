   /*
    https://leetcode.com/problems/valid-perfect-square/description/
    https://leetcode.com/problems/valid-perfect-square/submissions/1508946625/
     */
    public static boolean isPerfectSquareV2(int num) {

        if (num == 0 || num == 1) return true;

        long left = 2;
        long right = num / 2;

        while (left <= right) {

            long mid = left + (right - left) / 2;
            long midSquared = mid * mid;
            if (midSquared == num) return true;

            if (midSquared > num)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return false;
    }
