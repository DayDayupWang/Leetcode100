public class solution322 {
    public int coinChange(int[] coins, int amount) {
        // 完全背包，最少个数
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // 先物品
        for (int i = 0; i < coins.length; i++) {
            // 后背包
            for (int j = coins[i]; j <= amount; j++) {
                // 只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    // dp[j - coins[i]] + 1意味着装入coins[i]后得到价值+1
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }
}
