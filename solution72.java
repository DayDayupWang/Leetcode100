public class solution72 {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        // 以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，
        // word1想要转换成word2的最少次数。
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < len2 + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 字符相同时不会增长操作次数
                    dp[i][j] = dp[i - 1][j - 1];

                } else {
                    // 增删同效，word2也可以逆向编程word1
                    // 替换可以直接在i-1和j-1层面直接+1
                    // 如ac和ab直接替换，次数+1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }

            }
        }
        return dp[len1][len2];
    }
}
