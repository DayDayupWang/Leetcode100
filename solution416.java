import java.util.Arrays;

public class solution416 {
    public boolean canPartition(int[] nums) {
        // 01背包问题，只能放1次
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];// 0到target
        // 把0到i项物品拿出来检查
        for (int i = 0; i < nums.length; i++) {
            // 准备放入容纳数字nums[i]和为target到的背包中
            // dp[j - nums[i]]代表放入数值范围是0到j - nums[i]的最大价值
            // j >= nums[i]代表假如遇到取出的数字大于背包容量时跳过，是一种优化策略
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        if (target == dp[target]) {
            return true;
        }
        return false;
    }
}
