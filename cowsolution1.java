import java.util.Arrays;

public class cowsolution1 {
    public int maxRealValue(int m, int[] sellPrice, int[] realValue) {
        // 游游买鞋
        // 适合解法：贪心
        // write code here
        Arrays.sort(realValue);
        Arrays.sort(sellPrice);
        int sellsum = 0;
        for (int i = 0; i < sellPrice.length; i++) {
            sellsum += sellPrice[i];
        }
        int sum = 0;
        for (int i = 0; i < realValue.length; i++) {
            sum += realValue[i];
        }
        if (m >= sellsum) {
            return sum;
        }

        int[] dp = new int[sum + 1];
        dp[0] = 0;
        int res = 0;
        // 先遍历物品
        for (int i = 0; i < realValue.length; i++) {
            // 再遍历01背包
            for (int j = sum > m ? m : sum; j >= realValue[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - sellPrice[i]] + realValue[i]);
                res = res > dp[j] ? res : dp[j];
            }
            // 再遍历背包

        }
        return res;
    }
}
