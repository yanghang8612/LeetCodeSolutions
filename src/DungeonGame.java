import java.util.Arrays;

/**
 * 这个题用DP做，从右下角开始，按列进行处理，注意
 * 1.当处理最右侧列时，dp[m]应置为1，其他列dp[m]应置为Integer.MAX_VALUE，因为你总得有个出口吧，不能全是墙，
 *   到达公主房间时勇士应该至少有1点血，体现为公主房间的右侧或下方dp结果应该为1
 * 2.某个位置的最小需求血量应该是在右侧或下方需求血量的最小值的基础上，若当前位置为伤害（负数）时，加上其绝对值；
 *   若当前位置为治疗时，减去其绝对值，但是有可能当前位置的治疗很高，导致减去之后当前位置的需求血量变为负数，
 *   这是不允许的，血量至少应该为1
 */

public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            dp[m] = i == 1 ? 1 : Integer.MAX_VALUE;
            for (int j = 1; j <= m; j++) {
                int need = Math.min(dp[m - j + 1], dp[m - j]) - dungeon[m - j][n - i];
                dp[m - j] = need > 0 ? need : 1;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        //System.out.println(new DungeonGame().calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
        System.out.println(new DungeonGame().calculateMinimumHP(new int[][]{{0,-3}}));
    }
}
