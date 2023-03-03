public class solution309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1 || prices == null) {
            return 0;
        }
        int[][] dp = new int[prices.length][4];
        // dp[i][j]中 i表示第i天，j为 [0 - 3] 四个状态，
        // dp[i][j]表示第i天状态j所剩最大现金。
        // 0. 持有股票状态
        // 1. 保持卖出股票状态
        // 2. 刚卖出股票状态（因为接下来是冷冻期，所以暂时不能购入股票）
        // 3. 冷冻期

        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 持有股票的状态是由前一天持有的继续或者，保持卖出股票状态后购入，以及冷冻期结束购入
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]), dp[i - 1][3] - prices[i]);
            // 保持卖出股票状态是由前一天保持卖出股票状态的延续或者冷冻期的继续
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            // 刚卖出股票状态是由前一天持有股票状态卖出得到
            dp[i][2] = dp[i - 1][0] + prices[i];
            // 冷冻期的状态是由刚卖出股票状态推出
            dp[i][3] = dp[i - 1][2];

        }
        return Math.max(dp[prices.length - 1][1], Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));
    }
}