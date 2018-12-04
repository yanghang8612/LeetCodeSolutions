import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), begin = new HashSet<>(), end = new HashSet<>(), vis = new HashSet<>();
        begin.add(beginWord);
        if (dict.contains(endWord)) end.add(endWord);
        for (int len = 2; !begin.isEmpty(); len++) {
            Set<String> temp = new HashSet<>();
            for (String word : begin) {
                for (int i = 0; i < word.length(); i++) {
                    char[] ch = word.toCharArray();
                    for (char c = 'a'; c < 'z'; c++) {
                        if (c == word.charAt(i)) continue;
                        ch[i] = c;
                        String newWord = String.valueOf(ch);
                        if (end.contains(newWord)) return len;
                        if (dict.contains(newWord) && vis.add(newWord)) temp.add(newWord);
                    }
                }
            }
            begin = (temp.size() < end.size()) ? temp : end;
            end = (begin == temp) ? end : temp;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
