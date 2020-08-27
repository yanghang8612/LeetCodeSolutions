public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = 0;
                if (i > 0 && j > 0) cnt += board[i - 1][j - 1] > 0 ? 1 : 0;
                if (i > 0) cnt += board[i - 1][j] > 0 ? 1 : 0;
                if (i > 0 && j < m - 1) cnt += board[i - 1][j + 1] > 0 ? 1 : 0;
                if (j > 0) cnt += board[i][j - 1] > 0 ? 1 : 0;
                if (j < m - 1) cnt += board[i][j + 1] > 0 ? 1 : 0;
                if (i < n - 1 && j > 0) cnt += board[i + 1][j - 1] > 0 ? 1 : 0;
                if (i < n - 1) cnt += board[i + 1][j] > 0 ? 1 : 0;
                if (i < n - 1 && j < m - 1) cnt += board[i + 1][j + 1] > 0 ? 1 : 0;
                if (board[i][j] == 0 && cnt == 3) board[i][j] = -1;
                if (board[i][j] == 1) {
                    if (cnt < 2 || cnt > 3) board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = (board[i][j] + 2) % 2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(-1 % 2);
    }
}
