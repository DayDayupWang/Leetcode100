public class solution123 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1 || prices == null) {
            return 0;
        }
        int[][] dp = new int[prices.length][5];
        // dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，
        // dp[i][j]表示第i天状态j所剩最大现金。
        // 0. 没有操作
        // 1. 第一次持有
        // 2. 第一次不持有
        // 3. 第二次持有
        // 4. 第二次不持有
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }
}
