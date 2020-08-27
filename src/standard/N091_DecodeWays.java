package standard;

public class N091_DecodeWays {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int m = 1, n = 1;
        for (int i = 1; i < s.length(); i++) {
            int num = Integer.parseInt(s.substring(i - 1, i + 1));
            if (s.charAt(i) == '0') {
                if (num > 20) return 0;
                m ^= n;n ^= m;m ^= n;
            } else if (s.charAt(i - 1) == '0' || num > 26) {
                m = n;
            } else {
                int temp = m + n;
                m = n;
                n = temp;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new N091_DecodeWays().numDecodings("110"));
        System.out.println(new N091_DecodeWays().numDecodings("11010"));
    }
}
