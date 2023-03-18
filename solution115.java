public class solution115 {
    public static void main(String[] args) {

    }

    public int numDistinct(String s, String t) {
        // 以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }

        }
        return dp[s.length()][t.length()];
    }
}
