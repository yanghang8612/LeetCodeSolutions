package standard;

import java.util.HashMap;
import java.util.Map;

/**
 * 注意滑动窗口不应该像原先想的那样定义为t长度，也就是不能在遍历s的过程中找所有长度为t的窗口并判定其合法性，
 * 因为判定合法性比较麻烦
 */

public class N076_MinimumWindowSubstring {

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
        System.out.println(new N076_MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }
}
