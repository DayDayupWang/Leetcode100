public class solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

        }
        // 如果target过大 sum将无法满足
        if (target < 0 && sum < -target)
            return 0;
        if ((target + sum) % 2 != 0)
            return 0;
        int size = (target + sum) / 2;
        if (size < 0)
            size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        // dp[0] = 1，理论上也很好解释，
        // 装满容量为0的背包，有1种方法，就是装0件物品。
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];

    }
}
