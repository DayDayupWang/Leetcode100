public class solution198 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        // dp数组定义
        // 考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

}
