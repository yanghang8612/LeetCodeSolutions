package standard;

public class N791_CustomSortString {

    public String customSortString(String S, String T) {
        int[] cnt = new int[26];
        for (char c : T.toCharArray()) {
            cnt[c - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            sb.append(String.valueOf(c).repeat(Math.max(0, cnt[c - 'a'])));
            cnt[c - 'a'] = 0;
        }
        for (int i = 0; i < cnt.length; i++) {
            sb.append(String.valueOf((char) (i + 'a')).repeat(Math.max(0, cnt[i])));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
