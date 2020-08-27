package standard;

public class N115_DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (char c : s.toCharArray()) {
            int pre = dp[0];
            for (int i = 1; i <= n; i++) {
                int tmp = dp[i];
                if (c == t.charAt(i - 1)) {
                    dp[i] += pre;
                }
                pre = tmp;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new N115_DistinctSubsequences().numDistinct("aaa", "aa"));
    }
}
