public class solution377 {
    public static void main(String[] args) {

    }

    public int combinationSum4(int[] nums, int target) {
        // 本题求排列1，5和5，1是不同的排列
        // 1，5和5，1是同一个组合
        // dp[target]意为总和为target的数组组合数最多为dp[target]个
        int[] dp = new int[target + 1];

        dp[0] = 1;

        // 遍历背包
        for (int i = 0; i <= target; i++) {
            // 遍历物品
            for (int j = 0; j < nums.length; j++) {
                // 必须保证索引有效性
                if (i - nums[j] >= 0 && dp[i] < Integer.MAX_VALUE - dp[i - nums[j]]) {
                    dp[i] += dp[i - nums[j]];

                }

            }
        }
        return dp[target];
    }
}
