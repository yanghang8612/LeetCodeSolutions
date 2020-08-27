package standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N140_WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>[] list = new List[s.length() + 1];
        list[0] = new ArrayList<>();
        dfs(s, 0, wordDict, list);
        return list[0];
    }

    private void dfs(String s, int idx, List<String> dict, List<String>[] list) {
        if (idx == s.length()) {
            if (list[idx].size() == 0) {
                list[idx].add("");
            }
            return;
        }
        for (String word : dict) {
            if (s.startsWith(word, idx)) {
                int next = idx + word.length();
                if (list[next] == null) {
                    list[next] = new ArrayList<>();
                    dfs(s, next, dict, list);
                }
                if (list[next].size() != 0) {
                    for (String res : list[next]) {
                        list[idx].add(word + (res.length() == 0 ? "" : " ") + res);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(new N140_WordBreakII().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
//                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
        System.out.println(new N140_WordBreakII().wordBreak("catsanddog",
                Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
}
