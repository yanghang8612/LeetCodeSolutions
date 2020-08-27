package standard;

/**
 * 状态转移方程式关键，若i和j位置能匹配（包含字符匹配以及‘.’匹配），则dp[i][j] = dp[i - 1][j - 1]
 * 否则的话看j位置是否为‘*’，若是的话则又需要看它所重复字符是否匹配i位置，若不匹配，则‘#*’组合只能匹配为空
 * 若匹配的话，分三种情况，匹配零个（dp[i][j - 2]），匹配一个（dp[i - 1][j - 2]），匹配多个（dp[i - 1][j]）
 * 注意，初始化的时候要看dp[0][i]的情况，必须是带*的偶数匹配模式
 */

public class N010_RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 2; i < m + 1; i += 2) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2])
                dp[0][i] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                char cs = s.charAt(i - 1), cp = p.charAt(j - 1);
                if (cs == cp || cp == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (cp == '*') {
                    char c = p.charAt(j - 2);
                    if (c != '.' && c != cs) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {

    }
}
