import java.util.Arrays;

public class solution1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int len = stones.length;
        for (int i = 0; i < len; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];// 0到target
        // 把0到i项物品拿出来检查
        for (int i = 0; i < len; i++) {
            // 准备放入容纳数字stones[i]和为target到的背包中
            // dp[j - stones[i]]代表放入数值范围是0到j - stones[i]的最大价值
            // j >= stones[i]代表假如遇到取出的数字大于背包容量时跳过，是一种优化策略
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        // 尽可能去凑sum/2的重量
        // 以较大一堆的重量减去可能较小一堆的重量

        return sum - dp[target] - dp[target];

    }
}
