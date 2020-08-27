import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            if (!map.containsKey(sChars[i])) {
                if (!map.containsValue(tChars[i])) {
                    map.put(sChars[i], tChars[i]);
                } else {
                    return false;
                }
            } else if (map.get(sChars[i]) != tChars[i]) {
                return false;
            }
        }
        return true;
    }

    public IsomorphicStrings() {
        new Derived();
    }

    class Base {
        private String name = "Base";

        public Base() {
            this.tellName();
        }

        public void tellName() {
            System.out.println(this.name);
        }
    }

    class Derived extends Base {
        private String name = "Derived";

        public Derived() {
            super.tellName();
        }

        public void tellName() {
            System.out.println(this.name);
        }
    }

    public static void main(String[] args) {
        new IsomorphicStrings();
    }
}
