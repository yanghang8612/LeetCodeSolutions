package standard;

import java.util.LinkedList;
import java.util.Queue;

public class N130_SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int n = board.length, m = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if ('O' == board[i][0]) q.offer(new int[]{i, 0});
            if ('O' == board[i][m - 1]) q.offer(new int[]{i, m - 1});
        }
        for (int i = 1; i < m - 1; i++) {
            if ('O' == board[0][i]) q.offer(new int[]{0, i});
            if ('O' == board[n - 1][i]) q.offer(new int[]{n - 1, i});
        }
        while (!q.isEmpty()) {
            int x = q.peek()[0], y = q.poll()[1];
            board[x][y] = '-';
            if (x > 1 && board[x - 1][y] == 'O') q.offer(new int[]{x - 1, y});
            if (x < n - 1 && board[x + 1][y] == 'O') q.offer(new int[]{x + 1, y});
            if (y > 1 && board[x][y - 1] == 'O') q.offer(new int[]{x, y - 1});
            if (y < m - 1 && board[x][y + 1] == 'O') q.offer(new int[]{x, y + 1});
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '-') board[i][j] = 'O';
            }
        }
    }

    public static void main(String[] args) {
        new N130_SurroundedRegions().solve(new char[][]{{'X','X','X'},{'X','X','X'},{'X','X','X'}});
    }
}
