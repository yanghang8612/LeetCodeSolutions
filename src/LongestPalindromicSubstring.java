public class LongestPalindromicSubstring {

    // DP解法
    public String longestPalindromeWithDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String result = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // dp[i][j]依赖于dp[i + 1][j - 1]，说明在遍历i时需要知道下标大的值，i应该从
                // 后面往前遍历，遍历j时需要知道下标小的值，j应该从前往后遍历
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    // 奇偶扩展算法
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);
            if (s1.length() > max.length()) max = s1;
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }

    private String extend(String s, int i, int j) {
        for (; 0 <= i && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i + 1, j);
    }


    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaaa"));
    }
}
