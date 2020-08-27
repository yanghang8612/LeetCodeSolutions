package standard;

import java.util.Arrays;

public class N062_UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new N062_UniquePaths().uniquePaths(7, 3));
    }
}
