public class solution516 {
    public static void main(String[] args) {

    }

    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        // 字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            // 当i与j相同，那么dp[i][j]一定是等于1的
            dp[i][i] = 1;
        }
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                // 相同时长度直接+2
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[0][length - 1];
    }
}
