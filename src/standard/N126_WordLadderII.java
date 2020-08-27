package standard;

import java.util.*;

public class N126_WordLadderII {

    static class Node {
        boolean isFirst;
        String val;
        List<Node> preNodes;
        Node(String val) {
            this.val = val;
            this.preNodes = new ArrayList<>();
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (!wordList.contains(endWord)) return res;
        Set<String> topLevel = new HashSet<>(), endLevel = new HashSet<>(),
                dict = new HashSet<>(wordList);
        topLevel.add(beginWord);
        endLevel.add(endWord);
        Map<String, List<String>> map = new HashMap<>();
        boolean reverse = false, found = false;
        while (!topLevel.isEmpty()) {
            dict.removeAll(topLevel);
            Set<String> nextLevel = new HashSet<>();
            for (String word : topLevel) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char c = arr[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        arr[i] = j;
                        String nextWord = new String(arr);
                        if (endLevel.contains(nextWord)) found = true;
                        if (dict.contains(nextWord)) {
                            nextLevel.add(nextWord);
                            if (reverse) {
                                map.putIfAbsent(nextWord, new ArrayList<>());
                                map.get(nextWord).add(word);
                            } else {
                                map.putIfAbsent(word, new ArrayList<>());
                                map.get(word).add(nextWord);
                            }
                        }
                    }
                    arr[i] = c;
                }
            }
            if (found) {
                dfs(beginWord, endWord, new ArrayList<>(), map, res);
                return res;
            } else if(nextLevel.size() <= endLevel.size()) {
                topLevel = nextLevel;
            } else {
                topLevel = endLevel;
                endLevel = nextLevel;
                reverse = !reverse;
            }
        }
        return res;
    }

    private void dfs(String start, String end, List<String> path, Map<String, List<String>> map, List<List<String>> res) {
        path.add(start);
        if (end.equals(start)) {
            res.add(new ArrayList<>(path));
        } else if (map.containsKey(start)) {
            for (String s : map.get(start)) {
                dfs(s, end, path, map, res);
            }
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new N126_WordLadderII().findLadders("ymain", "oecij", Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain")));
    }
}
