/**
 * 这题的用动规，很明显
 * 补充一下，dp[i][j]表示将S的前i位字符变为T的前j位字符所需要的最小编辑距离
 * 状态转移方程上，我们假设dp[i - 1][j - 1]已知，而dp[i][j]的选择和S[i - 1]与T[j - 1]相关
 * 如果S[i - 1] = T[j - 1]，那么dp[i][j] = dp[i - 1][j - 1];
 * 如果S[i - 1] != T[j - 1]，那么根据三种不同类型的操作，有三种变换的方式：
 * 1.替换，将S[i - 1]替换为T[j - 1]，那么dp[i][j] = dp[i - 1][j - 1] + 1;
 * 2.删除，将S[i - 1]删除，那么dp[i][j] = dp[i - 1][j] + 1;
 * 3.插入，将T[j - 1]插入到S[i - 1]的后面，那么dp[i][j] = dp[i][j - 1] + 1；
 * 这三种方式都能将长度i的源串编辑为长度为j的目标串，所以选择其中最小的即可，这也是在用动规解决最小编辑距离中最小这个属性由来
 */

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int pre = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = pre;
                }
                else {
                    dp[j] = Math.min(pre, Math.min(dp[j - 1], dp[j])) + 1;
                }
                pre = temp;
            }
        }
        return dp[n];
    }
}
