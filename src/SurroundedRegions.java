import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int r = board.length, c = board[0].length;
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < c; i++) {
            if (board[0][i] == 'O') {
                q.offer(new Point(0, i));
                board[0][i] = '0';
            }
            if (board[r - 1][i] == 'O') {
                q.offer(new Point(r - 1, i));
                board[r - 1][i] = '0';
            }
        }
        for (int i = 0; i < r; i++) {
            if (board[i][0] == 'O') {
                q.offer(new Point(i, 0));
                board[i][0] = '0';
            }
            if (board[i][c - 1] == 'O') {
                q.offer(new Point(i, c - 1));
                board[i][c - 1] = '0';
            }
        }
        while (!q.isEmpty()) {
            Point point = q.poll();
            if (point.x > 0 && board[point.x - 1][point.y] == 'O') {
                q.offer(new Point(point.x - 1, point.y));
                board[point.x - 1][point.y] = '0';
            }
            if (point.x < r - 1 && board[point.x + 1][point.y] == 'O') {
                q.offer(new Point(point.x + 1, point.y));
                board[point.x + 1][point.y] = '0';
            }
            if (point.y > 0 && board[point.x][point.y - 1] == 'O') {
                q.offer(new Point(point.x, point.y - 1));
                board[point.x][point.y - 1] = '0';
            }if (point.y < c - 1 && board[point.x][point.y + 1] == 'O') {
                q.offer(new Point(point.x, point.y + 1));
                board[point.x][point.y + 1] = '0';
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '0') board[i][j] = 'O';
            }
        }
    }

    public static void main(String[] args) {
        //new SurroundedRegions().solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
        new SurroundedRegions().solve(new char[][]{{}});
    }
}
