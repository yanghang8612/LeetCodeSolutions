public class ShortestPalindrome {

    public String shortestPalindromeByKMP(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);
        return new StringBuilder(s.substring(table[temp.length() - 1])).reverse().toString() + s;
    }

    private int[] getTable(String s) {
        int[] table = new int[s.length()];
        int pre = 0, cur = 1;
        while (cur < table.length) {
            if (s.charAt(cur) == s.charAt(pre)) {
                table[cur++] = ++pre;
            } else {
                if (pre != 0) {
                    pre = table[pre - 1];
                } else {
                    table[cur++] = 0;
                }
            }
        }
        return table;
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            if (check(c, 0, i))
                return new StringBuilder(s.substring(i + 1, n)).reverse().toString() + s;
        }
        return "";
    }

    private boolean check(char[] c, int s, int e) {
        while (s < e) {
            if (c[s++] != c[e--]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestPalindrome().shortestPalindromeByKMP("abcd"));
    }
}
