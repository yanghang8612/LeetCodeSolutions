import java.util.*;

public class WordSearchII {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public List<String> findWordsByTrie(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '*' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }

        board[i][j] = '*';
        if (i > 0) dfs(board, i - 1, j, p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root =  new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.next[c - 'a'] == null) {
                    p.next[c - 'a'] = new TrieNode();
                }
                p = p.next[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length, m = board[0].length;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map.containsKey(board[i][j])) {
                    map.put(board[i][j], new ArrayList<>());
                }
                map.get(board[i][j]).add(i * m + j);
            }
        }
        boolean[][] vis = new boolean[n][m];
        List<String> res = new ArrayList<>();
        for (String word : words) {
            char c = word.charAt(0);
            if (map.containsKey(c)) {
                for (int i : map.get(c)) {
                    if (search(board, vis, word, 1, i / m, i % m)) {
                        res.add(word);
                        break;
                    }
                }
            }
        }
        return res;
    }

    private boolean search(char[][] board, boolean[][] vis, String word, int index, int i, int j) {
        if (index == word.length()) return true;
        vis[i][j] = true;
        char c = word.charAt(index);
        boolean left = false, top = false, right = false, bottom = false;
        if (j > 0 && !vis[i][j - 1]) left = c == board[i][j - 1] && search(board, vis, word, index + 1, i, j - 1);
        if (!left && i > 0 && !vis[i - 1][j]) top = c == board[i - 1][j] && search(board, vis, word, index + 1, i - 1, j);
        if (!top && j < board[0].length - 1 && !vis[i][j + 1]) right = c == board[i][j + 1] && search(board, vis, word, index + 1, i, j + 1);
        if (!right && i < board.length - 1 && !vis[i + 1][j]) bottom = c == board[i + 1][j] && search(board, vis, word, index + 1, i + 1, j);
        vis[i][j] = false;
        return left || top || right || bottom;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearchII().findWordsByTrie(
                new char[][]{{'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}}, new String[]{"oath","pea","eat","rain"}));
    }
}
