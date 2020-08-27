import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[256];
        int start = 0, max = 0;
        Arrays.fill(index, -1);
        for (int end = 0; end < s.length(); end++) {
            if (index[s.charAt(end)] < start) {
                max = Math.max(max, end - start + 1);
            } else {
                start = index[s.charAt(end)] + 1;
            }
            index[s.charAt(end)] = end;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
    }
}
