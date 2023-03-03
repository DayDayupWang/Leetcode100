public class solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 1 || prices == null) {
            return 0;
        }
        int[][] dp = new int[prices.length][k * 2 + 1];
        // dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，
        // dp[i][j]表示第i天状态j所剩最大现金。
        // 0. 没有操作
        // 1. 第一次持有
        // 2. 第一次不持有
        // 3. 第二次持有
        // 4. 第二次不持有
        for (int i = 0; i < 2 * k + 1; i++) {
            if (i %2 == 1) {
                dp[0][i] = -prices[0];
            }
        }
        // dp[0][0] = 0;
        // dp[0][1] = -prices[0];
        // dp[0][2] = 0;
        // dp[0][3] = -prices[0];
        // dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            int count = 0;
            while (count < k * 2) {
                count++;
                dp[i][count] = Math.max(dp[i - 1][count], dp[i - 1][count - 1] - prices[i]);
                count++;
                dp[i][count] = Math.max(dp[i - 1][count], dp[i - 1][count - 1] + prices[i]);
            }

        }
        return dp[prices.length - 1][k * 2];
    }
}
