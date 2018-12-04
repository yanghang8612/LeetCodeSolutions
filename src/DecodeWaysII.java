import java.util.HashMap;
import java.util.Map;

public class DecodeWaysII {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;
        long pri = 1, pre = s.endsWith("*") ? 9 : s.endsWith("0") ? 0 : 1, m = 1000000007;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                pri = pre;
                pre = 0;
            } else {
                long temp = pre;
                pre = ((s.charAt(i) == '*' ? pre * 9 : pre) + pri * doubleDecodings(s, i, i + 1)) % m;
                pri = temp;
            }
        }
        return (int) pre;
    }

    private int doubleDecodings(String s, int i, int j) {
        if (s.charAt(i) != '*' && s.charAt(j) != '*') {
            return Integer.valueOf(s.substring(i, i + 2)) <= 26 ? 1 : 0;
        } else if (s.charAt(i) == '*' && s.charAt(j) == '*') {
            return 15;
        } else if (s.charAt(i) == '*') {
            return s.charAt(j) < '7' ? 2 : 1;
        } else {
            return s.charAt(i) == '1' ? 9 : s.charAt(i) == '2' ? 6 : 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWaysII().numDecodings("**"));
    }
}
