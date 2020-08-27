package standard;

public class N097_InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (null == s3) {
            return false;
        }
        if (null == s1 || null == s2) {
            return s3.equals(s1) || s3.equals(s2);
        }
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        char[] s1Chars = s1.toCharArray(), s2Chars = s2.toCharArray(), s3Chars = s3.toCharArray();
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] && s1Chars[i - 1] == s3Chars[i - 1];
        }
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = dp[0][i - 1] && s2Chars[i - 1] == s3Chars[i - 1];
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                dp[i][j] = s1Chars[i - 1] == s3Chars[i + j - 1] && dp[i - 1][j] ||
                        s2Chars[j - 1] == s3Chars[i + j - 1] && dp[i][j - 1];
                if (!dp[i][j]) return false;
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {

    }
}
