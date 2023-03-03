public class solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int sumM = 0;
        int sumN = 0;
        int[] M = new int[strs.length];
        int[] N = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    sumM += 1;
                    count0++;
                }
                if (strs[i].charAt(j) == '1') {
                    sumN += 1;
                    count1++;
                }
                // Integer.valueOf(strs[i]) ;

            }
            M[i] = count0;
            N[i] = count1;
        }

        int[][] dp = new int[sumM + 1][sumN + 1];
        // 遍历物品
        for (int i = 0; i < strs.length; i++) {
            // 遍历0维度的背包
            for (int j = sumM; j >= M[i]; j--) {
                // 遍历1维度的背包
                for (int q = sumN; q >= N[i]; q--) {
                    dp[j][q] = Math.max(dp[j][q], dp[j - M[i]][q - N[i]] + 1);
                }

            }
        }
        return dp[m][n];
    }

}
