public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0, max = 0;
        for (int end = 0; end < s.length(); end++) {
            max = Math.max(max, ++count[s.charAt(end) - 'A']);
            if (end - start + 1 - max > k)
                count[s.charAt(start++) - 'A']--;
        }
        return Math.min(s.length(), max + k);
    }

    public static void main(String[] args) {

    }
}
