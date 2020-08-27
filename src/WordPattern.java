import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split("\\s");
        if (pattern.length() != words.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (map.containsValue(words[i])) return false;
                else map.put(c, words[i]);
            }
            if (!words[i].equals(map.get(c))) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
