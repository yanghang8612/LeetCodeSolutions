import java.util.*;
import java.util.function.IntConsumer;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0)
            return "";
        int[] record = new int[128];
        t.chars().forEach(value -> record[value]++);
        int begin = 0, end = 0, counter = t.length(), max = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            if (record[s.charAt(end++)]-- > 0) counter--;
            while (counter == 0) {
                if (end - begin < max) {
                    max = end - begin;
                    head = begin;
                }
                if (record[s.charAt(begin++)]++ == 0) counter++;
            }
        }
        return max == Integer.MAX_VALUE ? "" : s.substring(head, head + max);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }
}
