
// import java.util.TreeSet;

public class Solution121 {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 4, 6 };
        // int[] arr = { 7, 6, 4, 3, 1 };
        int MAx = maxProfit(arr);
        System.out.println(MAx);
    }

    public static int maxProfit(int[] prices) {
        // dp[i][0]数组表示第i天持有股票所得现金
        // dp[i][1]数组表示第i天不持有股票所得现金
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < dp.length; i++) {
            // 依赖于前一天持有股票和前一天不持有股票并购入两者的较大值
            // 此处由于买卖只有一次，所以前一天不持有股票的状态下直接是- prices[i]
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 依赖于前一天不持有股票和前一天持有股票并卖出两者的较大值
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}

// public static int maxProfit(int[] prices) {
// int max = 0;
// for (int i = 0; i < prices.length; i++) {
// for (int j = i + 1; j < prices.length; j++) {
// while (prices[i] < prices[j] && prices[j] - prices[i] > max) {
// max = prices[j] - prices[i];
// }
// }
// }
// return max;
// }