public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int pri = 1, pre = s.endsWith("0") ? 0 : 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                pri = pre;
                pre = 0;
            } else {
                pre = Integer.valueOf(s.substring(i, i + 2)) <= 26 ? pre + pri : pre;
                pri = Integer.valueOf(s.substring(i, i + 2)) <= 26 ? pre - pri : pre;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("27"));
    }
}
