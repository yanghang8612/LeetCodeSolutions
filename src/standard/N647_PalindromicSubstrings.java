package standard;

public class N647_PalindromicSubstrings {

    public int countSubstrings(String s) {
        char[] sChars = s.toCharArray();
        int n = sChars.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            int j = 1;
            while (i - j >= 0 && i + j < n && sChars[i - j] == sChars[i + j]) j += 1;
            cnt += j;
            j = 0;
            while (i - j >= 0 && i + j + 1 < n && sChars[i - j] == sChars[i + j + 1]) j += 1;
            cnt += j;
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
