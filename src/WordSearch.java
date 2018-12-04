
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && subExist(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean subExist(char[][] board, String word, int x, int y, int index) {
        if (index == word.length() - 1) return true;
        char cur = board[x][y];
        board[x][y] = 0;
        if (x - 1 >= 0 && board[x - 1][y] == word.charAt(index + 1) && subExist(board, word, x - 1, y, index + 1))
            return true;
        if (y - 1 >= 0 && board[x][y - 1] == word.charAt(index + 1) && subExist(board, word, x, y - 1, index + 1))
            return true;
        if (x + 1 < board.length && board[x + 1][y] == word.charAt(index + 1) && subExist(board, word, x + 1, y, index + 1))
            return true;
        if (y + 1 < board[0].length && board[x][y + 1] == word.charAt(index + 1) && subExist(board, word, x, y + 1, index + 1))
            return true;
        board[x][y] = cur;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCB"));
    }
}
