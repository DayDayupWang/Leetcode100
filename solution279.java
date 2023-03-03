public class solution279 {
    public int numSquares(int n) {
        // 完全背包问题
        // 组成和为i最少需要dp[i]个数字
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        // 先遍历物品（放入的完全平方数）
        for (int i = 1; i <= 100; i++) {
            // 再遍历背包
            for (int j = 1; j <= n; j++) {
                if (j - i * i >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);

                }
            }
        }
        return dp[n];
    }
}
