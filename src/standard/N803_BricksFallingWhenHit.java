package standard;

import java.util.*;

public class N803_BricksFallingWhenHit {

    private int n, m;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        if (grid == null || grid.length == 0 || grid[0].length == 0
                || hits == null || hits.length == 0 || hits[0].length == 0) return null;
        n = grid.length;
        m = grid[0].length;
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]] -= 1;
        }
        for (int i = 0; i < m; i++) {
            dfs(0, i, grid);
        }
        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            grid[x][y] += 1;
            if (grid[x][y] == 1 && isConnected(x, y, grid)) {
                res[i] = dfs(x, y, grid) - 1;
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return 1 + dfs(i - 1, j, grid) + dfs(i, j + 1, grid) + dfs(i + 1, j, grid) + dfs(i, j - 1, grid);
    }

    private boolean isConnected(int i, int j, int[][] grid) {
        if (i == 0) return true;
        int[] d = new int[]{-1, 0, 1, 0, -1};
        for (int k = 1; k < d.length; k++) {
            int x = i + d[k - 1], y = j + d[k];
            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N803_BricksFallingWhenHit().hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}}, new int[][]{{1, 1}})));
    }
}
