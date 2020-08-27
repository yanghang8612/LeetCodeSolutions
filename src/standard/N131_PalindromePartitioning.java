package standard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class N131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(0, i + 1);
            if (check(sub)) {
                for (List<String> subPartition : partition(s.substring(i + 1))) {
                    res.add(new ArrayList<>(subPartition));
                    res.get(res.size() - 1).add(0, sub);
                }
            }
        }
        if (check(s)) {
            res.add(new ArrayList<>());
            res.get(res.size() - 1).add(s);
        }
        return res;
    }

    private boolean check(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new N131_PalindromePartitioning().partition("aab"));

        IntStream.range(0, 10).toArray();
    }
}
