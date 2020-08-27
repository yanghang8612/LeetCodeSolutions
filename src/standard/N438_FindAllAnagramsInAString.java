package standard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N438_FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int cnt = p.length(), n = p.length();
        int[] records = new int[256];
        for (char c : p.toCharArray()) {
            records[c] += 1;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            records[c] -= 1;
            cnt -= records[c] < 0 ? 0 : 1;
        }
        for (int i = n; i < s.length(); i++) {
            if (cnt == 0) {
                res.add(i - n);
            }
            char c1 = s.charAt(i - n), c2 = s.charAt(i);
            records[c1] += 1;
            cnt += records[c1] > 0 ? 1 : 0;
            records[c2] -= 1;
            cnt -= records[c2] < 0 ? 0 : 1;
        }
        if (cnt == 0) {
            res.add(s.length() - n);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N438_FindAllAnagramsInAString().findAnagrams("abab", "ab"));
    }
}
