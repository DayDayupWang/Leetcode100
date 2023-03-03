import java.util.HashSet;
import java.util.List;

public class solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        // 完全背包，可以重复使用
        // dp[i] : 字符串长度为i的话，dp[i]为true，
        // 表示可以拆分为一个或多个在字典中出现的单词。
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // 再遍历背包，背包是由物品组成的待验证字符串
        for (int i = 1; i <= s.length(); i++) {
            // 先遍历物品，是否填入字符串
            for (int j = 0; j < i && !dp[i]; j++) {
                // 验证字符串部分
                //
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }

            }
        }

        return dp[s.length()];
    }
}
