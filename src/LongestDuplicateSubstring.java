import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestDuplicateSubstring {

    public String longestDupSubstring(String S) {
        int min = 0, max = S.length();
        String res = "";
        while (min <= max) {
            int mid = (min + max) / 2;
            String tmp = search(S, mid);
            if (tmp == null) {
                max = mid - 1;
            } else {
                min = mid + 1;
                if (tmp.length() > res.length()) {
                    res = tmp;
                }
            }
        }
        return res;
    }

    private String search(String s, int len) {
        if (len == 0) return "";
        else if (len >= s.length()) return null;
        Map<Long, List<Integer>> map = new HashMap<>();
        long p = (1 << 31) - 1, base = 26, hash = 0, m = 1;
        for (int i = 0; i < len; i++) {
            hash = (hash * base + (s.charAt(i) - 'a')) % p;
        }
        for (int i = 1; i < len; i++) {
            m = (m * base) % p;
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        map.put(hash, list);
        int start = 0, end = len;
        while (end < s.length()) {
            hash = ((hash - m * (s.charAt(start++) - 'a') % p + p) * base + (s.charAt(end++) - 'a')) % p;
            list = map.get(hash);
            if (list == null) {
                list = new ArrayList<>();
                map.put(hash, list);
            } else {
                for (int idx : list) {
                    if (s.substring(start, end).equals(s.substring(idx, idx + len))) {
                        return s.substring(start, end);
                    }
                }
            }
            list.add(start);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new LongestDuplicateSubstring().longestDupSubstring(""));
    }
}
