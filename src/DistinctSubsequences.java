/**
 * 注意第一行的初始化，target为空串时，一个字符串只有唯一一个空串子串，故而dp[0][i]均为1
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int sl = s.length(), tl = t.length();
        int[][] dp = new int[tl + 1][sl + 1];
        for (int i = 1; i <= tl; i++) {
            for (int j = i; j <= sl; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] += (i == 1 ? 1 : dp[i - 1][j - 1]);
                }
                dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[tl][sl];
    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("aaaa", "aaaa"));
    }
}
