package standard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N127_WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList),
                beginLevel = new HashSet<>(), endLevel = new HashSet<>();
        if (!dict.contains(endWord)) return 0;
        beginLevel.add(beginWord);
        endLevel.add(endWord);
        for (int len = 1; !beginLevel.isEmpty(); len++) {
            dict.removeAll(beginLevel);
            Set<String> nextLevel = new HashSet<>();
            for (String word : beginLevel) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char c = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String nextWord = new String(chars);
                        if (endLevel.contains(nextWord)) return len + 1;
                        if (dict.contains(nextWord)) nextLevel.add(nextWord);
                    }
                    chars[i] = c;
                }
            }
            if (nextLevel.size() > endLevel.size()) {
                beginLevel = endLevel;
                endLevel = nextLevel;
            } else {
                beginLevel = nextLevel;
            }
        }
        return 0;
    }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), topLevel = new HashSet<>();
        if (!dict.contains(endWord)) return 0;
        topLevel.add(beginWord);
        for (int len = 1; !topLevel.isEmpty(); len++) {
            dict.removeAll(topLevel);
            Set<String> nextLevel = new HashSet<>();
            for (String word : topLevel) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char c = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String nextWord = new String(chars);
                        if (endWord.equals(nextWord)) return len + 1;
                        if (dict.contains(nextWord)) nextLevel.add(nextWord);
                    }
                    chars[i] = c;
                }
            }
            topLevel = nextLevel;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new N127_WordLadder().ladderLength("ymain", "oecij", Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain")));
    }
}
