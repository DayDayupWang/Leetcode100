public class solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;

            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            res = dp[i] > res ? dp[i] : res;
        }
        return res;

    }
}
