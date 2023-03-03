public class solution213 {
    public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        int last = nums[nums.length - 1];
        int prelast = nums[nums.length - 2];
        dp[0] = Math.max(last, prelast + nums[0]);
        dp[1] = Math.max(dp[0], last + nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length-1];
    }
}
