package standard;

import java.lang.reflect.Array;
import java.util.Arrays;

public class N064_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) dp[j] += grid[i][j];
                else if (i == 0) dp[j] = grid[i][j] + dp[j - 1];
                else dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {

    }
}
