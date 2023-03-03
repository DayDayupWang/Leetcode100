public class solution122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cost = Integer.MAX_VALUE;
        // dp[i][0]数组表示第i天持有股票所得现金
        // dp[i][1]数组表示第i天不持有股票所得现金
        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            cost = Math.min(cost, prices[i]);
            profit = Math.max(profit, prices[i] - cost);
        }
        return profit;
    }
}
