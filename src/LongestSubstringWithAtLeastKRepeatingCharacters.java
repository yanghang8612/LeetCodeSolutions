public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        return div(s, 0, s.length(), k);
    }

    private int div(String s, int start, int end, int k) {
        if (end < start) return 0;
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a'] += 1;
        }
        int res = 0;
        for (int i = start, pre = start; i < end; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                res = Math.max(res, div(s, pre, i, k));
                pre = i + 1;
            } else if (i == end - 1) {
                if (pre == start) {
                    return end - start;
                } else {
                    res = Math.max(res, div(s, pre, end, k));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("aaabb", 3));
    }
}
