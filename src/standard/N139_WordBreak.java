package standard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 采用dfs搜索时,需要剪枝,不然解空间太大(2^n),
 * 比如在遍历完aaa……时,采用的组合是a.a.a……,
 * 那么采用a.aa……时,此时再往下层遍历将会经历相同的解空间
 */
public class N139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0 && !dp[i]; j--) {
                dp[i] = dp[j] && dict.contains(s.substring(j, i));
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {

    }
}
