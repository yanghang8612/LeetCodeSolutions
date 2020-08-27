package standard;

import java.util.*;

public class N890_FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character, Character> p = new HashMap<>();
        List<String> res = new ArrayList<>(Arrays.asList(words));
        int l = pattern.length();
        for (String word : words) {
            p.clear();
            if (word.length() == l) {
                for (int i = 0; i < l; i++) {
                    if (p.containsKey(pattern.charAt(i)) && p.get(pattern.charAt(i)) != word.charAt(i) ||
                            !p.containsKey(pattern.charAt(i)) && p.containsValue(word.charAt(i))) {
                        res.remove(word);
                        break;
                    }
                    p.put(pattern.charAt(i), word.charAt(i));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N890_FindAndReplacePattern().findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abc"));
    }
}
