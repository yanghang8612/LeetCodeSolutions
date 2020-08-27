public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] count = new int[24];
        for (char c : s.toCharArray()) {
            count[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            if (count[c - 'a'] == 0) return false;
            else count[c - 'a'] -= 1;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
