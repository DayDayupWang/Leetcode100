public class solution9 {
    public static void main(String[] args) {
        int a = 1011011;
        System.out.println(isPalindrome(a));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x <= 9) {
            return true;
        }
        String string = Integer.toString(x);
        int right = string.length() / 2;
        int left = 0;
        boolean[] dp = new boolean[right];
        if (string.length() % 2 == 0) {
            // 偶数串
            left = right - 1;
            dp[0] = string.charAt(right) == string.charAt(left) ? true : false;
        } else {
            // 奇数串
            dp = new boolean[right + 1];
            dp[0] = true;
            right++;
            left = right - 2;
        }

        for (int j = 1; j < dp.length; j++) {

            dp[j] = dp[j - 1] && string.charAt(left) == string.charAt(right) ? true : false;
            left--;
            right++;
        }

        return dp[dp.length - 1];
    }
}
