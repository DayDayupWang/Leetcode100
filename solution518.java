public class solution518 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[] { 1, 2, 5 };

        System.out.println("方法有：" + change(amount, coins) + "种");
    }
    public static int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 先遍历物品放入的硬币
        for (int i = 0; i < coins.length; i++) {
            // 再遍历背包
            for (int j = coins[i]; j <= amount; j++) {
                // coins[i]是背包容量，1是价值
                dp[j] = dp[j] + dp[j - coins[i]];
                for (int q = 0; q < dp.length; q++) {
                    System.out.print(dp[q] + " ");
                }
                System.err.println("|" + coins[i]);
            }
            System.err.println("--------");
        }
        return dp[amount];
    }
}
