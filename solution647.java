public class solution647 {
    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        int length = s.length();
        // [i,j]字串中是否是回文子串
        boolean[][] dp = new boolean[length][length];
        int res = 0;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        res++;
                    } else if (dp[i + 1][j - 1]) {
                        // 包含了i==j（a）和j=i+1 （aa）的情况
                        dp[i][j] = true;
                        res++;
                    }
                } else {
                    // ij字符不同的情况
                    dp[i][j] = false;
                }

            }

        }
        return res;
    }
}
