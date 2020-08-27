package standard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

public class N726_NumberOfAtoms {

    public String countOfAtoms(String formula) {
        StringBuilder sb = new StringBuilder(formula);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.push(i);
            } else if (sb.charAt(i) == ')') {
                int cnt = 0, j = i + 1;
                while (j < sb.length() && Character.isDigit(sb.charAt(j))) {
                    cnt = cnt * 10 + sb.charAt(j++) - '0';
                }
                cnt = cnt == 0 ? 1 : cnt;
                int start = stack.pop(), end = i;
                String t = multi(sb.substring(start + 1, end), cnt);
                sb.replace(start, j, t);
                i = start + t.length() - 1;
            }
        }
        return multi(sb.toString(), 1);
    }

    private String multi(String s, int times) {
        Map<String, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder(s.substring(0, 1));
        int cnt = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                String t = sb.toString();
                cnt = cnt == 0 ? 1 : cnt;
                map.putIfAbsent(t, 0);
                map.put(t, map.get(t) + cnt);
                sb = new StringBuilder(s.substring(i, i + 1));
                cnt = 0;
            } else if (Character.isLowerCase(c)) {
                sb.append(c);
            } else if (Character.isDigit(c)) {
                cnt = cnt * 10 + c - '0';
            }
        }
        String last = sb.toString();
        map.putIfAbsent(last, 0);
        map.put(last, map.get(last) + (cnt == 0 ? 1 : cnt));
        map.replaceAll((k, v) -> map.get(k) * times);
        return mapToString(map);
    }

    private String mapToString(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        map.forEach((s, i) -> sb.append(s).append(i == 1 ? "" : i));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new N726_NumberOfAtoms().countOfAtoms("(B2O39He17BeBe49)39"));
    }
}
